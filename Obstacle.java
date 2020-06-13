/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Spencer Dean
 */
public class Obstacle extends MovingGameObject{
    
    //Obstacle instance variables
    int size;
    
    //Obstacle constructor
    public Obstacle(int size, int xVelocity, int yVelocity, int xPos, int yPos, Color color) {
        super(xVelocity, yVelocity, xPos, yPos, color);
        super.setXVelocity(xVelocity);
        super.setYVelocity(yVelocity);
        super.setXPosition(xPos);
        super.setYPosition(yPos);
        super.setColor(color);
        this.size = size;
    }
    
    //get the size
    public int getSize()
    {
        return size;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(this.getXPosition(), this.getYPosition(), size, size);
        return r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillRect(super.getXPosition(), super.getYPosition(), size, size);
    }
    
}
