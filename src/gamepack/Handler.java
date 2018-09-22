package gamepack;


import input.KeyManager;
import input.MouseManager;
import states.State;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prafful
 */
public class Handler{
    
    private Game game;
    
    
    public Handler(Game game){
        this.game = game;
    }
    
    public int getWidth(){
        return game.width;
    }
    
    public int getHeight(){
        return game.height;
    }
    
    public KeyManager getKeyManager(){
        return game.getKeyManager();
    }
    
    public MouseManager getMm(){
        return game.getMm();
    }
    
    public Game getGame(){
        return game;
    }
    
    public void setGame(Game g){
        this.game = g;
    }
}
