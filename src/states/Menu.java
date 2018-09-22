
package states;


import java.awt.Graphics;
import gamepack.Handler;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import ui.UserInterface;


public class Menu extends State{
    
    //protected Handler handler;
    public static String name1 , name2;
    UserInterface ui;
    public Menu(Handler handler){
        super(handler);
        ui = new UserInterface(handler);
 
    }

    
    
    public void update() {
          
        System.out.println("mouse x:" + handler.getMm().getMouseX() + " " + "mouse y: " + handler.getMm().getMouseY());
        //if(handler.getMm().isLeftPressed()) State.setState(handler.getGame().gameState);
        if(handler.getGame().getKeyManager().play) {
            State.setState(handler.getGame().gameState);
        
        }
    }

    
    @Override
    public void render(Graphics g) {
           
          g.setColor(Color.RED);
          g.fillRect(handler.getMm().getMouseX(), handler.getMm().getMouseY(), 8, 8);
          g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
          g.drawString("Welcome to Smash the Bricks!!!", 200,400);
              g.setFont(new Font("TimesRoman", Font.PLAIN,24));
          g.setColor(Color.PINK);
          g.drawString("Try landing on the platform", 350,450);
          g.drawString("If you run into edges, you lose", 345,475);
          g.setColor(Color.BLACK);
          g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
          g.drawString("Press P to play the game",350,525);
          g.drawString("Enter SpaceBar to pause the game",350 , 550);
          g.setFont(new Font("TimesRoman", Font.PLAIN, 14));
          g.drawString("@Copyright Reserved by Prafful and Divya :) ", 700,890);
          
    }
}
