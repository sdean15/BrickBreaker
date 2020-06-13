/*
 * To change this license header, choose License Headers in Project Properties
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package Game;

import Controller.KeyboardController;
import GameObjects.Ball;
import GameObjects.Brick;
import GameObjects.GameObject;
import GameObjects.Obstacle;
import GameObjects.Paddle;
import GameObjects.PowerUp;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author araderma
 */
public class GamePanel extends JPanel
{
    // These are for handling the frame rate of the game and player controls
    // You should pass the controller to any objects you create that will
    //  be under keyboard control
    private Timer gameTimer; 
    private KeyboardController controller; 
    
    // Controls size of game window and framerate
    // You can adjust these if you want to use different values 
    private final int gameWidth = 570; 
    private final int gameHeight = 500; 
    private final int framesPerSecond = 60; 
    
    
    //instance variables
    int lives = 3;
    int timeMilli = 0;
    int timeSec = 0;
    int score = 0;
    Ball ball; 
    ArrayList<Brick> brickList;
    ArrayList<PowerUp> puList;
    Paddle paddle;
    Obstacle obstacle1;
    int highscore = 0;
    
    //create new Random for vaules would need it
    Random rand = new Random();
    

    //this method will create a grid of bricks
    private void createBrickLines(int numberOfLines)
    {
        //instantiates the arraylist with 11 bricks horizontally
        brickList = new ArrayList<>(11);
        //this for loop will create each brick object and space them
        for(int x = 0;x < 11;x++)
        {
            for(int y = 0;y < numberOfLines;y++)
            {
                //add the newly created brick to the list..setting color doesnt matter
                brickList.add(new Brick(50, 20, x * 52 + 5 , y * 24 + 35, Color.BLUE));
            }
        }
    }
    
    
    //this method will return us the current highscore from the highscore file
    public int getHighScore()
    {
        FileReader reader = null;
        BufferedReader bufReader = null;
        
        try
        {
            reader = new FileReader("highscore.dat");
            bufReader = new BufferedReader(reader);
            return bufReader.read();
        }catch (Exception ex)
        {
            return 0;
        }finally
        {
           try
           {
               if(bufReader != null)
               bufReader.close();
           }catch(IOException ex)
           {
               ex.printStackTrace();
           }
                  
        }
        
    }
    
    
    
    
    
    //this method will check if the current score is higher than the current highscore
    public void CheckScore()
    {
        //if the current score is higher than the current highscore, set the current score to the highscore
        if(score > highscore)
        {
            highscore = score;
            
            //create a new highscore file
            //if the file doesnt exist then will will create a new file
            File highScoreFile = new File("highscore.dat");
            if(!highScoreFile.exists())
            {
                try {
                    highScoreFile.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //used to write the new highscore the file
            FileWriter fileWriter = null;
            BufferedWriter bufWriter = null;
            
            //write the the highscore file and then close it
            try
            {
                fileWriter = new FileWriter(highScoreFile);
                bufWriter = new BufferedWriter(fileWriter);
                bufWriter.write(highscore);
            } catch (IOException ex) {
                Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
            }finally
            {
                if(bufWriter != null)
                {
                    try {
                        bufWriter.close();
                    } catch (IOException ex) {
                        Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
        }
    }

   
    
    
    /**
     * This method is called by the GameFrame class when starting the game for 
     *  the first time. It should be used like a constructor method where you
     *  initialize all of the instance variables. 
     * You can also use this method to reset a game after a player wins or loses
     *  and wants to play again. 
     */
    public final void setupGame()
    {
        //this will create our ball with size of 16, a random x Velocity of 1 or 2, y Velocity of 4
        ball = new Ball(16, rand.nextInt(2)+1, 4, 283, 250, Color.green);
 
        //this will create the PowerUp arraylist
        puList = new ArrayList<>();
       
        //this will create our paddle with a speed of 5
        paddle = new Paddle(65, 10, 5, controller, 259, 482, Color.white);
        
        //this will create our obstacle with a x Velocity of 2 and y Velocity of 0
        obstacle1 = new Obstacle(30, 2, 0, 75, 300, Color.ORANGE);
        
        //this will call the createBrickLines method
        //we passed 6 as an arg so that it will create 6 rows of bricks
        createBrickLines(6);

    }
    
    
    
    /**
     * This method is automatically called by the game timer every frame. As typical,
     *  you should use it to draw all of your game objects.
     * 
     * @param g The Graphics object used for drawing the GameObject instances.
     */
    @Override
    public void paint(Graphics g)
    {
        
        super.paint(g);

        
        //draws the paddle, obstacle, and ball
        paddle.draw(g);
        obstacle1.draw(g);
        ball.draw(g);
        
        
        //this draws the line above the top row of bricks
        g.setColor(Color.MAGENTA);
        g.drawLine(0, 32, 582, 32);
        
        
        //The string for lives :
        g.setColor(Color.white);
        g.drawString("Lives: ", 500, 20);


        //this will draw all of the bricks
        for(Brick brk: brickList)
        {
            brk.draw(g);
        }

        
        //this draws the PowerUp
        for(PowerUp pwr : puList)
        {
            pwr.draw(g);
        }
        
        
        //this will diplay our lives in top right corner
        String life = String.valueOf(lives);
        g.setColor(Color.white);
        g.drawString(life, 540, 20);
        
        
        //this will display the time elapsed in the top left corner
        String timeMilliSeconds = String.valueOf(timeMilli);
        String timeSeconds = String.valueOf(timeSec);
        g.drawString("Time : " + timeSeconds + " : " + timeMilliSeconds, 10, 20);
        
        
        //this displays the players current score
        String PlayerScore = String.valueOf(score);
        g.drawString("Score : " + PlayerScore, 420, 20);
        
        
        //displays brick-breaker text
        g.drawString("BRICK-BREAKER", 240, 20);
        
   
    }

    
    
    
    /**
     * This method is automatically called by the game timer every frame. Any of your
     *  code for moving game objects or handling collisions, etc. should be done 
     *  by this method. 
     * The method has a single parameter which represents the 
     *  current frame number, which is incremented by the Timer each time before 
     *  the method is called. You can assume that it will always increase, but it
     *  will eventually overflow if the game runs long enough (something like 1 year)
     * 
     * @param frameNumber The number of the current frame.
     */
    public void updateGameState(int frameNumber)
    {
        //move methods
        paddle.move();
        ball.move();
        for (PowerUp pwr : puList)
        {
            pwr.move();
        }
        
        //everytime this is updated the milliseconds increase by 1
        //if the milliseconds equal 60, then it will return to 0 and 
        //increase the seconds by 1
        timeMilli++;
        if(timeMilli == 60)
        {
            timeSec++;
            timeMilli = 0;
        }
        
        //this is so if the ball hits the bottom "wall", the lives will decrease by 1
        if(ball.getYPosition() >= getHeight() - ball.getDiameter())
        {
            lives--;
        }
        
        
        //this will handle the lose end game popup
        if(lives == 0)
        {
            CheckScore();
            int input = JOptionPane.showConfirmDialog(null, "You ran out of Lives!\nScore : " + score + "\nTime elapsed: " + timeSec + " seconds\nDo you want to play again?",
            "End Game", JOptionPane.YES_NO_OPTION);
            //stop the game
            gameTimer.stop();
            //if user selects yes reset the game else exit the program
            if(input == 0)
            {
                timeSec = 0;
                timeMilli = 0;
                lives = 3;
                score = 0;
                start();
            }else
            {
                System.exit(0);
            }
        }
        
        
        //this will handle the win end game popup
        if(brickList.isEmpty())
        {
            CheckScore();
            gameTimer.stop();
            int input = JOptionPane.showConfirmDialog(null, "You Broke all the Bricks!\nScore: " + score + "\nCompleted in " + timeSec + " seconds", 
            "End Game", JOptionPane.YES_NO_OPTION);
            if(input == 0)
            {
                timeSec = 0;
                timeMilli = 0;
                lives = 3;
                score = 0;
                start();
            }else
            {
                System.exit(1);
            }
        }
        
        
        //if the powerup collides with paddle then increase lives by 1
        for(int i = 0; i < puList.size();i++)
        {
            if(puList.get(i).isColliding(paddle))
            {
                puList.remove(i);
                lives++;
            }
           
        }
        
        
        
        //if the ball is colliding with paddle change x and y velocities
        if(ball.isColliding(paddle))
        {  
            ball.setXVelocity(ball.getXVelocity());
            ball.setYVelocity(-ball.getYVelocity()); 
        }
        
        //if ball collides with the obstacle then change x and y velocities
        if(ball.isColliding(obstacle1))
        {
            ball.setXVelocity(ball.getXVelocity());
            ball.setYVelocity(-ball.getYVelocity());
        }
        
        
        //this will check each brick in the bricklist
        for(int i = 0;i < brickList.size();i++)
        {
            //this checks if the ball is colliding with the brick and the current 
            //iteration, then cast a new random and see if a powerup will spawn
            //otherwise continue to change the ball velocities, remove the brick
            //and update the score
            if(ball.isColliding(brickList.get(i)))
            {
               Random rand = new Random();
               if(rand.nextInt(35) == 0)
               {
                   puList.add(new PowerUp('P', brickList.get(i), 0, 1, brickList.get(i).getXPosition() + brickList.get(i).getWidth()/2,
                   brickList.get(i).getYPosition() + brickList.get(i).getHeight(), Color.yellow)); 
               }
               ball.setXVelocity(-ball.getXVelocity());
               ball.setYVelocity(-ball.getYVelocity());
               brickList.remove(i);
               score +=  (brickList.size() *8) / (timeSec / 2);

            }
        }
        
        
        //if the balls y position is less than or greater than the windows height
        //if the balls x position is less than or greater than the window width
        if(ball.getYPosition() >= getHeight()- ball.getDiameter() || ball.getYPosition() <= 32)
        {
            ball.setYVelocity(-ball.getYVelocity());
        }else if(ball.getXPosition() >= getWidth() - ball.getDiameter() || ball.getXPosition() <= 0)
        {
            ball.setXVelocity(-ball.getXVelocity());
        }
        
        
        //if the paddles x position is greater than the width, then set its x position
        //to 0 and vice versa
        if(paddle.getXPosition() >= getWidth())
        {
            paddle.setXPosition(0);
        }else if(paddle.getXPosition() <= 0)
        {
            paddle.setXPosition(getWidth());
        }
        
        
        //this if statement will move the obstacle1 from left to right maintaing its xPosition
        obstacle1.move();
        //if the obstacles xPosition is greater than or less than the width of the panel, its xVelocity will reverse
        if(obstacle1.getXPosition() >= getWidth() || obstacle1.getXPosition() <= 0)
        {
            obstacle1.setXVelocity(-obstacle1.getXVelocity());
        
        }//this does the same as above but with Y values
        else if(obstacle1.getYPosition() >= getHeight() || obstacle1.getYPosition() <= 0)
        {
            obstacle1.setYVelocity(-obstacle1.getYVelocity());
        }
              
    }
    
   
    
    /**
     * Constructor method for GamePanel class.
     * It is not necessary for you to modify this code at all
     */
    public GamePanel()
    {
        // Set the size of the Panel
        this.setSize(gameWidth, gameHeight);
        this.setPreferredSize(new Dimension(gameWidth, gameHeight));
        
        this.setBackground(Color.BLACK);
        
        // Register KeyboardController as KeyListener
        controller = new KeyboardController(); 
        this.addKeyListener(controller); 
        
        // Call setupGame to initialize fields
        this.setupGame(); 
        
        this.setFocusable(true);
        this.requestFocusInWindow();
        
    }
    
    
    
    /**
     * Method to start the Timer that drives the animation for the game.
     * It is not necessary for you to modify this code unless you need to in 
     *  order to add some functionality. 
     */
    public void start()
    {
        setupGame();
        // Set up a new Timer to repeat every 20 milliseconds (50 FPS)
        gameTimer = new Timer(1000 / framesPerSecond, new ActionListener() {

            // Tracks the number of frames that have been produced.
            // May be useful for limiting action rates
            private int frameNumber = 0; 
                        
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                // Update the game's state and repaint the screen
                updateGameState(frameNumber++);
                repaint();  
            }
        });
        
        gameTimer.setRepeats(true);
        gameTimer.start();
  
    }

    
    
}
