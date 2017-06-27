/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

/**
 *
 * @author Team 
 */
public class PlayerControl {
    
    public int checkWeight(int inventoryWeight, int newWeight) {
        
        if (inventoryWeight < 0 || inventoryWeight >100) {// inventory weight is invalid
            return -1;
            
        }
        
        if (newWeight < 0 || newWeight > 100) {//New weight is invalid
            return -1;
        }
        
        if ((newWeight + inventoryWeight) > 100) { //total weight is to high.
            return -1;
        }
        
        int capacityRemaining = 100 - (inventoryWeight + newWeight);
            
        return capacityRemaining;
    }
    
    public int cast(int strength, int fishWeight) {
        if (strength < 1 || strength > 10) {
            return -1;
        }
        
        if (fishWeight < 1 || fishWeight > 20) {
            return -1;
        }
        
        int hookSetAccuracy = Math.abs(2 * strength - fishWeight);
        
        return hookSetAccuracy;
    }
 /**
 *
 * @author Kelly Huber
 */
    public int carryWeight(int fuelWeight, int baitWeight) {
        
        if (fuelWeight < 0 || fuelWeight >50) {// fuel weight is invalid
            return -1;
        }
        
        if (baitWeight < 0 || baitWeight > 50) {//Bait weight is invalid
            return -1;
        }
        
        if ((fuelWeight + baitWeight) > 50) { //total weight is to high.
            return -1;
        }
        
        int strengthRemaining = 50 - (fuelWeight + baitWeight);
            
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

    public double carryWeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
