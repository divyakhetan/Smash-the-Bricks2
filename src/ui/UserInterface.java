
package ui;

import gamepack.Handler;
import java.applet.Applet;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import states.State;


public class UserInterface extends Applet implements ActionListener{

    Button exit, play;
    Handler handler;
    
    
    public UserInterface(Handler handler){
        this.handler = handler;
        System.out.println("Constructor");
    }
    
    public void init(){
        exit = new Button("Exit");
        play = new Button("Play");
        add(exit);
        add(play);
        exit.addActionListener(this);
        play.addActionListener(this);
        System.out.println("init");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("actionperformed");
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == play){
            State.setState(handler.getGame().gameState);
        }
    }
    
}
