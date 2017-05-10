/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;

/**
 *
 * @author Kelly
 */
public class MarinaScene implements Serializable{
    // class instance variables
    private double bait;
    private double fuel;
    private double money;

    public MarinaScene() {
    }
    
    

    public double getBait() {
        return bait;
    }

    public void setBait(double bait) {
        this.bait = bait;
    }

    public double getFuel() {
        return fuel;
    }

    public void setFuel(double fuel) {
        this.fuel = fuel;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.bait) ^ (Double.doubleToLongBits(this.bait) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.fuel) ^ (Double.doubleToLongBits(this.fuel) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.money) ^ (Double.doubleToLongBits(this.money) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "MarinaScene{" + "bait=" + bait + ", fuel=" + fuel + ", money=" + money + '}';
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MarinaScene other = (MarinaScene) obj;
        if (Double.doubleToLongBits(this.bait) != Double.doubleToLongBits(other.bait)) {
            return false;
        }
        if (Double.doubleToLongBits(this.fuel) != Double.doubleToLongBits(other.fuel)) {
            return false;
        }
        if (Double.doubleToLongBits(this.money) != Double.doubleToLongBits(other.money)) {
            return false;
        }
        return true;
    }
    
    
}
