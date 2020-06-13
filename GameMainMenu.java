/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Spencer Dean
 */
public class GameMainMenu extends JPanel{
    
 
        JLabel gameTitleLabel;
        JLabel highscoreLabel;
        JButton startButton;
        JButton exitButton;
        GamePanel gp;
        
        Font titleFont = new Font("Times New Roman", Font.TRUETYPE_FONT, 55);
        
       
       public GameMainMenu() 
       {
           gp = new GamePanel();

            this.setLayout(null);
            this.setSize(582, 500);
            this.setPreferredSize(new Dimension(570, 500));
            this.setBackground(Color.BLACK);

            gameTitleLabel = new JLabel("BRICK-BREAKER");
            gameTitleLabel.setForeground(Color.white);
            gameTitleLabel.setBounds(75, 15, 450, 150);
            gameTitleLabel.setFont(titleFont);

            startButton = new JButton("START");
            startButton.setBackground(Color.black);
            startButton.setForeground(Color.white);
            startButton.setBounds(250, 200, 75, 35);
            startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    GameFrame gf = new GameFrame();
                    gf.setVisible(true);
                    new GameMainMenu().setVisible(false);
                }
            });

            exitButton = new JButton("EXIT");
            exitButton.setBackground(Color.BLACK);
            exitButton.setForeground(Color.white);
            exitButton.setBounds(250, 250, 75, 35);
            exitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    System.exit(0);
                }
            });
            
            
            String highscore = String.valueOf(gp.getHighScore());
            
            highscoreLabel = new JLabel("Highscore : " + highscore);
            highscoreLabel.setForeground(Color.white);
            highscoreLabel.setBounds(240, 350, 150, 50);
            

            this.add(highscoreLabel);
            this.add(gameTitleLabel);
            this.add(startButton);
            this.add(exitButton);
            

        }

        
    }
