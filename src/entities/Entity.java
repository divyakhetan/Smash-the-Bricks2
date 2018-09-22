/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.creatures.Creature;
import gamepack.Game;
import java.awt.Graphics;

/**
 *
 * @author Prafful
 */
public abstract class Entity {
    
    protected float x, y;
    protected int width, height;
    protected int rad; // for circular entities
    
    public Entity(float x, float y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public Entity(){
        rad = Creature.DEFAULT_BALL_RAD;
        x = Game.width / 2;
        y = Game.height - Creature.DEFAULT_PLAYER_HEIGHT - rad;
    }
    
    public void setX(float x){
        this.x = x;
    }
    
     public void setY(float y){
        this.y = y;
    }
     
      public void setWidth(int width){
        this.width = width;
    }
      
       public void setHeight(int height){
        this.height = height;
    }
    
       public float getX(){
            return x;
        }
       
       public float getY(){
            return y;
        }
       
       public int getWidth(){
           return width;
       }
       
       public int getHeight(){
           return height;
       }
       
    public abstract void update();
    public abstract void render(Graphics g);

    /**
     * @return the rad
     */
    public int getRad() {
        return rad;
    }

    /**
     * @param rad the rad to set
     */
    public void setRad(int rad) {
        this.rad = rad;
    }
}
