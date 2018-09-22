/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamepack;

import display.Display;

/**
 *
 * @author Prafful
 */
public class Launcher {
    public static void main(String[] args){
        Game game = new  Game("SMASH THE BRICKS!", 1000, 900);
        game.start();
    }
}
