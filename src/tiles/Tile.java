/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiles;

import gamepack.Game;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Prafful
 */
public class Tile {
    
    public static final int TILEWIDTH = 200;
    public static final int TILEHEIGHT = 15;
    Color c;
    
    
    public int x, y;
    Random r = new Random();
    
    //CLASS
    public Tile(){
        x = Math.abs(r.nextInt() % (Game.width - TILEWIDTH));
        y = Game.height / 3 +  Math.abs(r.nextInt() % Game.height / 3);
        System.out.println(x + " " + y);
        
        int red = 1 + Math.abs(r.nextInt() % 255);
        int blue = 1 +  Math.abs(r.nextInt() % 255);
        int green = 1 +  Math.abs(r.nextInt() % 255);
        c = new Color(red, green, blue);
        System.out.println(red + " " + green + " " + blue);
    }
    
    public void update(){
        
    }
    
    public void render(Graphics g){
        g.setColor(c);
        g.fillRect(x, y, TILEWIDTH, TILEHEIGHT);
    }
}
