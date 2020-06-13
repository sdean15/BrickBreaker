/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import Game.GamePanel;

/**
 *
 * @author Spencer Dean
 */
public class PowerUp extends MovingGameObject{
    
    //PowerUp instance variables
    char symbol;
    

    //PowerUp constructor
    public PowerUp(char symbol, Brick parent,int xVelocity, int yVelocity, int xPos, int yPos, Color color) {
        super(xVelocity, yVelocity, xPos, yPos, color);
        this.symbol = symbol;
    }
    

    @Override
    public Rectangle getBounds() {
       Rectangle r = new Rectangle(this.getXPosition(), this.getYPosition(), 15, 15);
       return r;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(super.getColor());
        char[] c = {symbol};
        g.drawRect(super.getXPosition()- 5, super.getYPosition() - 12, 15, 15);
        g.drawChars(c, 0, 1, super.getXPosition(), super.getYPosition());
    }
    
}
