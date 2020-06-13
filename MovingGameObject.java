/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Interfaces.Moveable;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Spencer Dean
 */
public abstract class MovingGameObject extends GameObject implements Moveable{
 
    //instance variables
    int xVelocity;
    int yVelocity;

    //default constructor
    public MovingGameObject(int xVelocity, int yVelocity, int xPos, int yPos, Color color) 
    {
        super(xPos, yPos, color);
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;  
    }
    
    
    //get and set methods
    public int getXVelocity()
    {
        return xVelocity;
    }
    
    public int getYVelocity()
    {
        return yVelocity;
    }
    
    public int YVelocity()
    {
        return yVelocity;
    }
    
    public void setXVelocity(int xVelocity)
    {
        this.xVelocity = xVelocity;
    }
    
    public void setYVelocity(int yVelocity)
    {
        this.yVelocity = yVelocity;
    }
    
    
    //this method will take care of movement of any object that calls it
    @Override
    public void move()
    {
        this.setXPosition(this.getXPosition() + xVelocity);
        this.setYPosition(this.getYPosition()+ yVelocity);
    }
    
}
