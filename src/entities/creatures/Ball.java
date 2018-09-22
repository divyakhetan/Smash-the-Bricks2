/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.creatures;

import gamepack.Game;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Prafful
 */
public class Ball extends Creature{

    private Player p, p2;
    public Player lastHit;
    InputStream in;
    AudioStream as;
    public Ball(Player p, Player p2) throws FileNotFoundException, IOException {
        super();
        this.p = p;
        this.p2 = p2;
        lastHit = this.p;
        speed = 4.0f;
                

    }

    
    
    
    @Override
    public void update() {
        if(x + rad > Game.width || x < 0) xMove *= -1;
        if(y < 0) yMove *= -1;
        if(x >= p.getX() && x + rad <= p.getX() + Creature.DEFAULT_PLAYER_WIDTH && Game.height - Creature.DEFAULT_PLAYER_HEIGHT < y + rad && y + rad < Game.height){ 
                lastHit = p;
                p.score += 50;
                yMove *= -1;
              //  AudioPlayer.player.start(as);
        }
        if(x  >= p2.getX() && x + rad <= p2.getX() + Creature.DEFAULT_PLAYER_WIDTH && y < Creature.DEFAULT_PLAYER_HEIGHT && y > 0){
            lastHit = p2;
            p2.score += 50;
            yMove *= -1;
            //AudioPlayer.player.start(as);
        }
        move();
    }

    @Override
    public void render(Graphics g) {
        g.fillOval((int)x, (int)y, rad, rad);
    }
    
}
