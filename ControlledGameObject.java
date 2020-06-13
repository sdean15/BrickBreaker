/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Controller.KeyboardController;
import Interfaces.Moveable;
import java.awt.Color;

/**
 *
 * @author Spencer Dean
 */
public abstract class ControlledGameObject extends GameObject implements Moveable{

    KeyboardController control;

    public ControlledGameObject(KeyboardController control, int xPos, int yPos, Color color) {
        super(xPos, yPos, color);
        this.control = control;
    }
    
}
