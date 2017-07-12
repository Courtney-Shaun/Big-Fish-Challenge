/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;
import java.util.Objects;


/**
 *
 * @author Kelly
 */
public class Fish implements Serializable{
    // Class instance variables
    private double weight;

    public Fish() {
    }
    

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    
}
