/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gamepack.Game;
import gamepack.Handler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Prafful
 */
public class ExitState extends State{

    //private Handler handler;
    
    public ExitState(Handler handler) {
        super(handler);
    }

    @Override
    public void update() {
                System.out.println("In exit");
                if(handler.getGame().getKeyManager().cont){
                    handler.getGame().init();
                }
                if(handler.getGame().getKeyManager().exit){
                    System.exit(0);
                }
                

    }

    @Override
    public void render(Graphics g) {
            g.setColor(Color.BLUE);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
            g.drawString("Enter C to continue playing the game", 290,435);
            g.setColor(Color.RED);
            g.drawString("Enter E to exit playing the game", 290,465);
          g.fillRect(handler.getMm().getMouseX(), handler.getMm().getMouseY(), 8, 8);
    }
    
}
