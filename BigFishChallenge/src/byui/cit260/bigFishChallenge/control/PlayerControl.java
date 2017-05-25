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
    
    
    
}
