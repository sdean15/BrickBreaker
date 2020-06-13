/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Spencer Dean
 */

//adds extends
public class Paddle extends ControlledGameObject{
    
    //instance variables for paddle
    int width;
    int height;
    int speed;
    
    
    //constructor for the paddle object
    public Paddle(int width, int height, int speed, KeyboardController controller, int xPos, int yPos, Color color) {
        super(controller, xPos, yPos, color);
        this.width = width;
        this.height = height;
        this.speed = speed;
    }
    
    
    //get and set methods for the paddle
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public void setSpeed(int speed)
    {
        this.speed = speed;
    }
    
    //this method will take care of paddle movement via left and right arrows on keyboard
    @Override
    public void move()
    {
        if(control.getLeftKeyStatus() == true)
        {
            super.setXPosition(super.getXPosition() - speed);
        }else if(control.getRightKeyStatus() == true)
        {
            super.setXPosition(super.getXPosition() + speed);
        }
    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(this.getXPosition(), this.getYPosition(), width, height);
        return r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), width, height);
    }
    
}
