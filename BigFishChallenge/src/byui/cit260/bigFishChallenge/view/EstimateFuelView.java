/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import java.util.Scanner;

/**
 *
 * @author Shaun Courtney
 */
public class EstimateFuelView extends View {
    
    
    private String distance;
    private String gallons;
        
     public EstimateFuelView() {
        super("\n"
               + "\n----------------------------------------"
               + "\n Estimate the fuel you need!           |"
               + "\n----------------------------------------"
               + "\n Use this tool to make sure you         "
               + "\n will have enough fuel to make it       "
               + "\n to your destination. Each square is 5  "
               + "\n miles.  Moving 3 squares would be 15   "
               + "\n miles.  You can travel up to 40 miles  "
               + "\n on a full tank of fuel.  Enter how     "
               + "\n many miles you wish to travel and how  "
               + "\n much fuel you have in inventory.  You  "
               + "\n will then learn if you have enough     "
               + "\n fuel or not.                           "
               + "\n----------------------------------------");
            
     }
    // diplays the Estimate fuel view 

    @Override 
    public void display() {
        System.out.println(displayMessage);
        boolean done = false; // set flag to not done
        do {
            // Get the option
            double input = getDoubleInput("\n How many miles do you want to travel?(No more than 40)", 40, 1);
            if (input == -999) // user wants to quit
                return; // exit the game
        
            double inputTwo = getDoubleInput("\n How many gallons of fuel do you have? (No more than 8)", 8, 1);
            if (inputTwo == - 999) // user wants to quit
                return; // exit the game
            try {
            // do the requested action and display the next view
            done = this.doAction(input, inputTwo);
            } catch (PlayerControlException ne) {
                System.out.println(ne.getMessage());
            }
                
        } while (!done);
    }

    
    public boolean doAction(double input, double inputTwo) throws PlayerControlException {
        
        //choice = choice.toUpperCase(); // convert choice to upper case
        double distance = input;
        double gallons = inputTwo;
        double gallonsLeft;
        
        PlayerControl playerControl = new PlayerControl();
       
        
        gallonsLeft = playerControl.estimateFuel(distance, gallons);
        
        if (gallonsLeft < 0) {
            this.notEnough();
            return false;
        } else {
            this.canMakeIt();
        }
    
        
        return true;
    }
    
    private void notEnough() {
        System.out.println("\n You do not have enough fuel to travel that far!  Get to the Marina and buy some Fuel!");
        
    
    }

    private void canMakeIt() {
        System.out.println("\n You can make it with the fuel that you have!");
       
    }

    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
