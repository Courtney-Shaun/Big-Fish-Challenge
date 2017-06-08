/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.PlayerControl;
import java.util.Scanner;

/**
 *
 * @author shaunathan
 */
public class EstimateFuelView {
    
    private String menu;
    private String distance;
    private String gallons;
        
     public EstimateFuelView() {
        this.menu = "\n"
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
                  + "\n----------------------------------------";
        
        
        
    
     }

    public void displayEstimateFuelView() {
        
        boolean done = false; // set flag to not done
        do {
            // Get the option
            String input = this.getInput();
            
            if (input.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
        
            String inputTwo = this.getInputTwo();
            if (inputTwo.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(input, inputTwo);
            
        } while (!done);
    }
    
    public String getInput() {
        
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selection = null;
        
        // while a valid entry has not been retrieved
        while (!valid) {
            
            System.out.println("\n" + this.menu);
            System.out.println("\n How many miles do you want to travel?");
            
            // get the value entered from the keyboard
            selection = keyboard.nextLine();
            selection = selection.trim();
            
            if (selection.length() < 1) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            } else if ("q".equals(selection)){
                return selection;
            } else if (Double.parseDouble(selection) > 40 || (Double.parseDouble(selection) < 1)) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            } 
                
        break;
        }  
        
        return selection;
    }
    
    public String getInputTwo() {
        
        Scanner keyboard = new Scanner(System.in);
        boolean valid = false;
        String selectionTwo = null;
        
        // while a valid entry has not been retrieved
        while (!valid) {
            
            System.out.println("\n How many gallons of fuel do you have?");
            // get the value entered from the keyboard
            selectionTwo = keyboard.nextLine();
            selectionTwo = selectionTwo.trim();
            
            if (selectionTwo.length() < 1) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            } else if ("q".equals(selectionTwo)){
                return selectionTwo;
            } else if (Double.parseDouble(selectionTwo) > 8 || (Double.parseDouble(selectionTwo) < 1)) {
                System.out.println("\n*** Invalid selection *** Try again");
                continue;
            } 
            
            break;
        }
        
        return selectionTwo;
    }

   

    private boolean doAction(String input, String inputTwo) {
        
        //choice = choice.toUpperCase(); // convert choice to upper case
        double distance = Double.parseDouble(input);
        double gallons = Double.parseDouble(inputTwo);
        double gallonsLeft;
        
        PlayerControl playerControl = new PlayerControl();
       
        
        gallonsLeft = playerControl.estimateFuel(distance, gallons);
        
        if (gallonsLeft < 0) {
            this.notEnough();
        } else {
            this.canMakeIt();
        }
    
        
        return false;
    }
    
    private void notEnough() {
        System.out.println("\n You do not have enough fuel to travel that far!  Get to the Marina and buy some Fuel!");
    }

    private void canMakeIt() {
        System.out.println("\n You can make it with the fuel that you have!");
    }

    
        
        
}
     
  
   
   