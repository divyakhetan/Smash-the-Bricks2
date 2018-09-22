/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.creatures;

import gamepack.Game;
import java.awt.Graphics;
import gamepack.Handler;

/**
 *
 * @author Prafful
 */
public class Player extends Creature{

    public float length = 130;
    public float breadth = 20;
    public int score = 0;
    private boolean left;
    private boolean right;
    public String name = "";
    
    private Handler handler;
    
    public Player(Handler handler, float x, float y, boolean left, boolean right) {
        super(x, y, Creature.DEFAULT_PLAYER_WIDTH, Creature.DEFAULT_PLAYER_WIDTH);
        this.handler = handler;
        this.left = left;
        this.right = right;
    }

    @Override
    public void update() {
        getInput();
        move();
    }
    
    private void getInput(){
        xMove = 0;
        yMove = 0;
        
        if(x < 0) {
            x += 3;
            xMove = 0;
        }
        
        if(x > handler.getGame().width - length) {
            x -= 3;
            xMove = 0;
        }
        
        //player1 controls
        if(left && x > 0) xMove = -speed;
        if(right && x + Creature.DEFAULT_PLAYER_WIDTH < Game.width) xMove = speed;
        // player2 controls.
        /*
        if(handler.getGame().getKeyManager().left2 && x > 0) xMove = -speed;
        if(handler.getGame().getKeyManager().right2 && x + Creature.DEFAULT_PLAYER_WIDTH < Game.width) xMove = speed;
        */
}

    @Override
    public void render(Graphics g) {
        g.fillRect((int)x, (int)y, (int)length, (int)breadth);
    }

    /**
     * @param left the left to set
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }
    
}
