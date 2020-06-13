/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 *
 * @author Spencer Dean
 */
public class Brick extends GameObject{
    
    //Brick instance variables
    int width;
    int height;
    
    //used for to create a random color
    Random rand = new Random();
    
    //used to generate a random int that will be passed as a color value
    int r = rand.nextInt(256);
    int g = rand.nextInt(256);
    int b = rand.nextInt(256);
    
    //create a random color
    Color randColor = new Color(r, g, b);
    

    //Brick constructor
    public Brick(int width, int height, int xPos, int yPos, Color color) {
        super(xPos, yPos, color);
        this.width = width;
        this.height = height;
    }
    
    
    //Brick get and set methods
    public int getWidth()
    {
        return width;
    }
    
    public int getHeight()
    {
        return height;
    }
    
    public void setWidth(int width)
    {
        this.width = width;
    }
    
    public void setHeight(int height)
    {
        this.height = height;
    }

    
    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(this.getXPosition(), this.getYPosition(), width, height);
        return r;
    }

    
    @Override
    public void draw(Graphics g) {
        g.setColor(randColor);
        g.fillRect(super.getXPosition(), super.getYPosition(), width, height);
    }
    
    
    
}
