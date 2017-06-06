/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;
import java.util.Random;
import byui.cit260.bigFishChallenge.control.PlayerControl;

/**
 *
 * @author Cody
 */

public class CastALineView {
    
    private String menu;
    private int weight;
    
    public CastALineView(String fishWeightText, int weight) {
        this.menu = "\n"
                  + "\n------------------------------------------------"
                  + "\n| You've cast your line in the water           |"
                  + "\n------------------------------------------------"
                  + "\n"
                  + "\n  You just felt a" + fishWeightText + "tug!"
                  + "\n"
                  + "\n  To set the hook, enter a pull strength (1-10)"
                  + "\n------------------------------------------------";
        
        this.weight = weight;
    }
    /**
     * displays the display menu view
     */
    public void displayCastView() {
        
        boolean done = false; // set flag to not done
        do {
            //prompt for and get players name
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(menuOption);
            
        } while (!done);
              
        
    }
    private String getMenuOption() {
        
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank.");
                continue;
            } else if(Integer.parseInt(value) > 10){
                System.out.println("\nInvalid value: please enter a valid number.");
                continue;
            }
            
            break;
        }
        
        return value;
        
    }

    private boolean doAction(String choice) {
        
        //choice = choice.toUpperCase(); // convert choice to upper case
        int choiceInt = Integer.parseInt(choice);
        double hookSetAccuracy;
        
        PlayerControl playerControl = new PlayerControl();
        
        hookSetAccuracy = playerControl.cast(choiceInt, weight);
        
        if (hookSetAccuracy < 4) {
            this.fishCaught();
        } else {
            this.fishGotAway();
        }
        
            
        
       
        return true;
    }

    private void fishCaught() {
        System.out.println("*** fishCaught function called ***");
    }

    private void fishGotAway() {
        System.out.println("*** fishGotAway function called ***");
    }

    
}
