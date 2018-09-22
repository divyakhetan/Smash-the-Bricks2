/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Prafful
 */
public class KeyManager implements KeyListener{

    private boolean[] keys;
    public boolean left = false, right = false, play,cont, exit;
    public boolean left2 = false, right2 = false;
    public boolean pauseKey;
    public boolean pause = false;
    
    public KeyManager(){
        keys = new boolean[256];
    }
    
    public void update(){
        left = keys[KeyEvent.VK_LEFT];
        right = keys[KeyEvent.VK_RIGHT];
        right2 = keys[KeyEvent.VK_D];
        left2 = keys[KeyEvent.VK_A];
        play = keys[KeyEvent.VK_P];
        cont = keys[KeyEvent.VK_C];
        exit = keys[KeyEvent.VK_E];    
        //pauseKey = keys[KeyEvent.VK_SPACE];
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
        char a = e.getKeyChar();
        if(a == ' ') { 
            pause = !pause;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        //System.out.println("Pressed!");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    
}
