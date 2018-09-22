/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gamepack.Game;
import gamepack.Handler;
import java.awt.Graphics;
//import java.util.logging.Handler;

/**
 *
 * @author Prafful
 */
public abstract class State {
    
    private static State currentState = null;
    
    public static void setState(State s){
        currentState = s;
    }
    
    public static State getState(){
        return currentState;
    }
    
    protected Handler handler;
    
    public State(Handler handler){
        this.handler = handler;
    }
       
    public abstract void update();
    public abstract void render(Graphics g);
    
    
}
