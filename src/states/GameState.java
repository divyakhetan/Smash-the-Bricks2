/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entities.creatures.Ball;
import entities.creatures.Creature;
import entities.creatures.Player;
import gamepack.Game;
import java.awt.Graphics;
import tiles.Tile;
import gamepack.Handler;
import java.awt.Color;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import States.*;
import java.awt.Component;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.*;

/**
 *
 * @author Prafful
 */ 

public class GameState extends State{

   // protected Handler handler;
    private Player player, player2, winner;
    Tile t;
    Ball b;
    Random r = new Random();
    int score;
    String highscore = "";
    int winnerScore = 0;
    boolean tie = false;
    InputStream in1, in2;
    AudioStream as1,as2;
    
    public GameState(Handler handler) throws FileNotFoundException, IOException{
        super(handler);
        score = 0;
        // make 2 players.
        player = new Player(handler, handler.getGame().width / 2 - Creature.DEFAULT_PLAYER_WIDTH / 2, handler.getGame().height - Creature.DEFAULT_PLAYER_HEIGHT, handler.getKeyManager().left, handler.getKeyManager().right);
        player2 = new Player(handler, handler.getGame().width / 2 - Creature.DEFAULT_PLAYER_WIDTH / 2, 0, handler.getKeyManager().left2, handler.getKeyManager().right2);
        player.setSpeed(player.getSpeed() * 1.2f);
        t = new Tile();
        b = new Ball(player, player2);
        player.score = -50;
      //  in1 = new FileInputStream("C:\\Users\\divya\\Downloads\\system-fault.au"); // exit
       // in2 = new FileInputStream("C:\\Users\\divya\\Downloads\\maro_coin_sound.au"); 
        //as = new AudioStream(in);
    //    as1 = new AudioStream(in1);
        //as2 = new AudioStream(in2);
    }
    
    @Override
    public void update() {
        if(!handler.getKeyManager().pause) {

        player.setLeft(handler.getKeyManager().left);
        player.setRight(handler.getKeyManager().right);
        player2.setLeft(handler.getKeyManager().left2);
        player2.setRight(handler.getKeyManager().right2);
        player.update();
        player2.update();
        b.update();
        }
        
        if(b.getX() + b.getRad() > t.x && b.getX() - b.getRad() < t.x + Tile.TILEWIDTH && b.getY() + b.getRad() > t.y && b.getY() + b.getRad() < t.y + Tile.TILEHEIGHT) {
            //b.setxMove((float) (b.getxMove() * Math.pow(-1, new Random().nextInt() % 2))); // change the x instead of the y, randomly.
            b.lastHit.score += 200;
            System.out.println("p1:" + player.score + " " + "p2:" + player2.score);
            t = new Tile();
            score += 200;
            if(score > 0 && score % 1000 == 0){
                b.setxMove(b.getxMove() * 1.1f);
                b.setyMove(b.getyMove() * 1.1f);
                player.setxMove(player.getxMove() * 1.1f);
                player.setyMove(player.getyMove() * 1.1f);
                player2.setxMove(player2.getxMove() * 1.1f);
                player2.setyMove(player2.getyMove() * 1.1f);
            }
            System.out.println("Score :" + score);
        }

        if(b.getY() > Game.height){
            player2.score += 500;
            if(player.score == player2.score) {
                JOptionPane.showMessageDialog(new JFrame(), "It's a tie! Score: " + player.score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                tie = true;
            }
            if(player.score > player2.score) {
                winner = player;
                JOptionPane.showMessageDialog(new JFrame(), "Player1 wins! Score: " + player.score ,"Game Over",JOptionPane.INFORMATION_MESSAGE);
                winnerScore = player.score;
                winner = player;
            } 
            else {
                winner = player2;
                JOptionPane.showMessageDialog(new JFrame(), "Player2 wins! Score: " + player2.score, "Game Over",JOptionPane.INFORMATION_MESSAGE);
                winnerScore = player2.score;
                
            }
            if(!tie){
            try {
                checkscore();
            } catch (IOException ex) {
                Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            State.setState(handler.getGame().exitState);
        }
        if(b.getY() < 0){
            //AudioPlayer.player.start(as1);
            player.score += 500;
            if(player.score == player2.score) {
                JOptionPane.showMessageDialog(new JFrame(), "It's a tie! Score: " + player.score, "Game Over", JOptionPane.INFORMATION_MESSAGE);
                tie = true;
            }
            if(player.score > player2.score) {
                winner = player;
                JOptionPane.showMessageDialog(new JFrame(), "Player 1 wins! Score: " + player.score ,"Game Over",JOptionPane.INFORMATION_MESSAGE);
                winnerScore = player.score;
                winner = player;
            } 
            else {
                winner = player2;
                JOptionPane.showMessageDialog(new JFrame(), "Player 2 wins! Score: " + player2.score, "Game Over",JOptionPane.INFORMATION_MESSAGE);
                winnerScore = player2.score;
                
            }
            if(!tie){
            try {
                checkscore();
            } catch (IOException ex) {
                Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            State.setState(handler.getGame().exitState);
        }
        
        if(highscore.equals("")) {
            try {
                highscore = this.getHighScore();
            } catch (IOException ex) {
                Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    

    @Override
    public void render(Graphics g) {
        player.render(g);
        player2.render(g);
        b.render(g);
        t.render(g);
        g.setColor(Color.ORANGE);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        g.drawString (" Player 2: "+ player2.score, 830,30);
        g.drawString(" Player 1: " + String.valueOf(player.score), 830,55);
        g.drawString("High Score: " + highscore, 10, 30);
    }
    
    public String getHighScore() throws IOException{
        FileReader readFile = null;
        BufferedReader reader = null;
        try{
          readFile = new FileReader("highscore.dat");
          reader = new BufferedReader(readFile);
          return reader.readLine();
        }
        catch(FileNotFoundException e){
            return "Nobody:0";
        }
        finally{
            if(reader != null)
            reader.close();
        }
    }
    
    public void checkscore() throws IOException{
        if(winnerScore >Integer.parseInt(highscore.split(":")[1])) {
            String name = JOptionPane.showInputDialog("Congratulations! You have set a new high score! What's your name?");
            highscore = name + ":" + winnerScore;
            
            File scoreFile = new File("highscore.dat");
            if(!scoreFile.exists()) {
                try {
                    scoreFile.createNewFile();
                 } catch (IOException ex) {
                Logger.getLogger(GameState.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
            
            FileWriter wf = null;
            BufferedWriter w = null;
            
            try{
                wf = new FileWriter(scoreFile);
                w = new BufferedWriter(wf);
                w.write(highscore);
            }
            catch(IOException e){
            }
            finally{
                if(w != null) 
                    w.close();
            }
        }
    }
}