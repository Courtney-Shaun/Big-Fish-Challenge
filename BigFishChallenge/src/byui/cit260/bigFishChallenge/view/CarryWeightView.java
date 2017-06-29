/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;
import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kelly Huber
 */

public class CarryWeightView extends View{
    
  
    private String fuelWeight;
    private String baitweight;
    
    public CarryWeightView() { 
        super("\n"
                  + "\n------------------------------------------------"
                  + "\n You've purchased fuel and bait           "
                  + "\n------------------------------------------------"
                  + "\n"
                  + "\n  Answer the questions to determine"
                  + "\n  if you have enough strength. "  
                  + "\n------------------------------------------------");
     
       
    }
    /**
     * displays the display carryWeight view
     */
    @Override
    public void display() { 
        System.out.println(displayMessage); 
        boolean done = false; // set flag to not done
        do {
            //prompt 
            //String input = this.getInputOne();
            int input = getIntInput("\n How much fuel did you buy?(No more than 50)", 50, 1);
            if (input == -999) // user wants to quit
                return; // exit the game
            
            //String inputTwo = this.getInputTwo();
            int inputTwo = getIntInput("\n How much bait did you buy?(No more than 50)", 50, 1);
            if (inputTwo == -999) // user wants to quit
                return; // exit the game
            try {
                //do the requested action and display the next view
                done = this.doAction(input, inputTwo);
            } catch (PlayerControlException ex) {
                System.out.println(ex.getMessage());
            }
            
        } while (!done);
    }
    
    

    public boolean doAction(int input, int inputTwo)  throws PlayerControlException{
        
        //choice = choice.toUpperCase(); // convert choice to upper case
        int fuelWeight = input;
        int baitWeight = inputTwo;
        int strengthRemaining; 
        
        
        PlayerControl playerControl = new PlayerControl();
        
        strengthRemaining = playerControl.carryWeight(fuelWeight,baitWeight); 
        
        if (strengthRemaining < 1) { 
            this.noStrength();
            return false;
        } else {
            this.enoughStrength();
        }
        
        return true;
    }
    private void noStrength() {
        System.out.println("\n You do not have enough strength to carry your supplies!");
    }

    private void enoughStrength() {
        System.out.println("\n You can carry your supplies back to your boat!");
    }
    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    