/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.creatures;

import entities.Entity;

/**
 *
 * @author Prafful
 */
public abstract class Creature extends Entity{
    
    public static final int DEF_HEALTH = 10;
    public static final float DEF_SPEED = 6.0f;
    public static final int DEFAULT_PLAYER_WIDTH = 130,
                            DEFAULT_PLAYER_HEIGHT = 20, 
                            DEFAULT_TILE_WIDTH = 100,
                            DEFAULT_BALL_RAD = 20;
    
    
    
    protected int health;
    protected float speed;
    protected float xMove, yMove;
    
    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        health = DEF_HEALTH;
        speed = DEF_SPEED;
        xMove = yMove = 0;
    }
    
    public Creature(){
        super();
        health = DEF_HEALTH;
        speed = DEF_SPEED;
        xMove = yMove = DEF_SPEED;
    }
    
    public void move(){
        x += xMove;
        y += yMove;
    }
    
    // getters and setters
    
    public void setHealth(int health){
        this.health = health;
    }
    
    public int getHealth(){
        return health;
    }
    
    public void setSpeed(float speed){
        this.speed = speed;
    }
    
    public float getSpeed(){
        return speed;
    }
    
    public void setxMove(float xMove){
        this.xMove = xMove;
    }
    
    public void setyMove(float yMove){
        this.yMove = yMove;
    }
    
    public float getxMove(){
        return xMove;
    }
    
   public float getyMove(){
       return yMove;
   }
   
   
    
}
