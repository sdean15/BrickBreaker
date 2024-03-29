/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import javax.swing.JFrame;

/**
 *
 * @author araderma
 */
public class GameFrame extends JFrame
{
    private GamePanel game;
   
    
    public GameFrame()
    { 
         // Add text to title bar 
        super("Brick Breaker");
        
        // Make sure the program exits when the close button is clicked
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        // Create an instance of the Game class and turn on double buffering
        // to ensure smooth animation
        game = new GamePanel();
        game.setDoubleBuffered(true);
        
        // Add the Breakout instance to this frame's content pane to display it
        this.getContentPane().add(game); 
        this.pack();
        
        //this makes it so the window is fixed
         //sets the frame to appear in middle of monitor
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        // Start the game
        game.start();  
        
    }

    
}
