/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepack;

/**
 *
 * @author Prafful
 */

import display.Display;
import gfx.ImageLoader;
import input.KeyManager;
import input.MouseManager;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import states.ExitState;
import states.GameState;
import states.Menu;
import states.Pause;
import states.State;
import static sun.audio.AudioPlayer.player;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prafful
 */
public class Game implements Runnable {
    private Display display;
    private String title;
    
    public static int width, height;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    
    //States
    public State gameState;
    public State menuState;
    public State exitState;
    public State pauseState;

    // input
    KeyManager km;
    private MouseManager mm;
    
    private Handler handler;
    
    public Game(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        km = new KeyManager();
        mm = new MouseManager();
    }
    
    public void init() throws IOException{
        display = new Display(title, width, height);
        ImageIcon img = new ImageIcon("C:\\Users\\divya\\Desktop\\python\\strawberry.png");
        display.getFrame().setIconImage(img.getImage());
        display.getFrame().addKeyListener(km);
        handler = new Handler(this);
        display.getCanvas().addMouseListener(mm);
        display.getCanvas().addMouseMotionListener(mm);
        display.getFrame().addMouseListener(mm);
        display.getFrame().addMouseMotionListener(mm);
        //testImage = ImageLoader.loadImage("C:\\Users\\Prafful\\Documents\\NetBeansProjects\\newGame\\res\\textures\\test.png");
        gameState = new GameState(handler);
        menuState = new Menu(handler); 
        //pauseState = new Pause(handler);
        exitState = new ExitState(handler);
        State.setState(menuState);
        

    }
    
    public void update(){
        km.update();
        
        if(State.getState() != null){
            State.getState().update();
        }
    }
    
    public void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        // clear the screen. required before we start drawing
        g.clearRect(0, 0, width, height);
        // start drawing
        if(State.getState() != null){
            State.getState().render(g);
        }
        
        // end drawing
        bs.show();
        g.dispose();
    }
    
    public void run(){
        try {
            init();
        } catch (IOException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long time = 0;
        long ticks = 0;
        
        
        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            time += now - lastTime;
            
            lastTime = now;
            
            if(delta >= 1){
            update();
            render();
            ticks++;
            delta--;
            }
            if(time >= 1000000000){
                System.out.println("Ticks and frames : " + ticks);
                ticks = 0;
                time = 0;
            }
        }
        
        stop();
    }
    
    public KeyManager getKeyManager(){
        return km;
    }
    
    public synchronized void start(){
        if(running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public synchronized void stop(){
        if(!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
    }

    /**
     * @return the mm
     */
    public MouseManager getMm() {
        return mm;
    }

    /**
     * @param mm the mm to set
     */
    public void setMm(MouseManager mm) {
        this.mm = mm;
    }

}

