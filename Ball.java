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
public class Ball extends MovingGameObject{
    
    //Ball instance variables
    int diameter;

    //Ball constructor
    public Ball(int diameter, int xVelocity, int yVelocity, int xPos, int yPos, Color color) {
        super(xVelocity, yVelocity, xPos, yPos, color);
        this.diameter = diameter;
    }
    
    //Ball get method
    public int getDiameter()
    {
        return diameter;
    }

    @Override
    public Rectangle getBounds() {
        Rectangle r = new Rectangle(this.getXPosition(), this.getYPosition(), diameter, diameter);
        return r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        g.fillOval(super.getXPosition(), super.getYPosition(), diameter, diameter);
    }
    
}
