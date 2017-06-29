/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;

/**
 *
 * @author Team 
 */
public class PlayerControl {    
    
    
    public int checkWeight(int inventoryWeight, int newWeight) throws PlayerControlException {
        
        if (inventoryWeight < 0 || inventoryWeight >100) {// inventory weight is invalid
            throw new PlayerControlException("Invalid Inventory Weight.");            
        }
        
        if (newWeight < 0 || newWeight > 100) {//New weight is invalid
            throw new PlayerControlException("Invalid Purchase Weight.");
        }
        
        if ((newWeight + inventoryWeight) > 100) { //total weight is to high.
            throw new PlayerControlException("Invalid Total Weight.");
        }
        
        int capacityRemaining = 100 - (inventoryWeight + newWeight);            
        return capacityRemaining;
    }
    
    
    
    public int cast(int strength, int fishWeight) {       
        
        int hookSetAccuracy = Math.abs(2 * strength - fishWeight);        
        return hookSetAccuracy;
    }
 /**
 *
 * @author Kelly Huber
 */
    public static int carryWeight(int fuelWeight, int baitWeight) throws PlayerControlException {
        
        if (fuelWeight < 0 || fuelWeight >50) {// fuel weight is invalid
            throw new PlayerControlException("Invalid Fuel Weight.");
        }
        
        if (baitWeight < 0 || baitWeight > 50) {//Bait weight is invalid
            throw new PlayerControlException("Invalid Bait Weight.");
        }
        
        if ((fuelWeight + baitWeight) > 50) { //total weight is to high.
            throw new PlayerControlException("Invalid Total Weight.");
        }
        
        int strengthRemaining = 50 - (fuelWeight + (baitWeight * 4));            
        return strengthRemaining;
    }
 /**
 *
 * @author Shaun Courtney
 */
    
    public double estimateFuel(double distance, double gallons) {
        
        if (distance <= 0) {
            return -1;
        }
        
        if (gallons <= 0 || gallons > 8) {
            return -1;
        }
        
        double milesPerGallon = 5;
        double gallonsLeft = gallons - (distance / milesPerGallon);        
        return gallonsLeft;
    }

    
}
