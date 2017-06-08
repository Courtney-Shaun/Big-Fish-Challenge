/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;
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
            
            //System.out.println(value);
            //if ("1".equals(value)) System.out.println("THIS MATCHES");
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank.");
                continue;
            } else if("1".equals(value) || "2".equals(value) || "3".equals(value) || "4".equals(value) || "5".equals(value) || "6".equals(value) || "7".equals(value) || "8".equals(value) || "9".equals(value) || "10".equals(value)) {
                valid = true;
                continue;
                
            } else {
                System.out.println("\nInvalid entry.");
                continue;
            }

            
            
            
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
        StartNewGameView startNewGameView = new StartNewGameView();
        startNewGameView.displayStartNewGameView(); 
    }

    private void fishGotAway() {
        System.out.println("*** fishGotAway function called ***");
        StartNewGameView startNewGameView = new StartNewGameView();
        startNewGameView.displayStartNewGameView(); 
    }

    
}
