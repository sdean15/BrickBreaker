/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Interfaces.Drawable;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author Spencer Dean
 */
public abstract class GameObject implements Drawable{
    
    //instance variables
    private int xPosition;
    private int yPosition;
    private Color color;
    
    
    //default constructor
    public GameObject(int xPos, int yPos, Color color)
    {
        this.xPosition = xPos;
        this.yPosition = yPos;
        this.color = color;
        
    }
    
    //abstract method to get the rectangle bounds
    public abstract Rectangle getBounds();
    
    
    //get and set methods
    public int getXPosition()
    {
        return xPosition;
    }
    
    public int getYPosition()
    {
        return yPosition;
    }
    
    public Color getColor()
    {
        return color;
    }
    
    public void setXPosition(int xPos)
    {
        this.xPosition = xPos;
    }
    
    public void setYPosition(int yPos)
    {
        this.yPosition = yPos;
    }
    
    public void setColor(Color color)
    {
        this.color = color;
    }
    
    
    //determines if a game object is colliding with another game object
    public boolean isColliding(GameObject other)
    {  
        if(this.getBounds().intersects(other.getBounds()))
        {
            return true;
        }else
        {
            return false;
        }

    }
    
}
