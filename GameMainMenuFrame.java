/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Spencer Dean
 */
public class GameMainMenuFrame extends JFrame{
    
    private GameMainMenu mainMenu;
            
    public GameMainMenuFrame()
    {
        //Set the title
        super.setTitle("Brick-Breaker");
        
        //create new instance of the MainMenu Panel
        mainMenu = new GameMainMenu();
    
        //this will cause the window to stop and close if close button is clicked
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    
        //adds the MainMenu panel to the frame
        this.getContentPane().add(mainMenu);
        this.pack();
        
        //this makes it so the window size is fixed
        //sets the frame to appear in middle of monitor
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
    }
    
    //used to run the program and start the Main menu
     public static void main(String[] args) 
    {
        
         java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new GameMainMenuFrame().setVisible(true);
            }
        });
        
    }
    
}
