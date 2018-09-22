
package states;

import gamepack.Handler;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author divya
 */
public class Pause extends State{
    
    public Pause(Handler handler){
        super(handler);
    }
    
    @Override
    public void update(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pause.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        State.setState(handler.getGame().gameState);
    }

    /**
     *
     * @param g
     */
    @Override
    public void render(Graphics g) {
        g.drawString("Paused", 200,200);
    }
    
    
}
