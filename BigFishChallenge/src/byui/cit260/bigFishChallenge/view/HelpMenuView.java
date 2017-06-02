/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;

/**
 *
 * @author shaunathan
 */
public class HelpMenuView {
    
    private String menu;
    
    
    public HelpMenuView() {
        this.menu = "\n"
                  + "\n--------------------------------"
                  + "\n Help Menu                     |"
                  + "\n--------------------------------"
                  + "\nO - Objective of the game"
                  + "\nF - About Fuel"
                  + "\nB - About Bait"
                  + "\nC - Casting a Line"
                  + "\nI - Interpreting Clues"
                  + "\nQ - Quit"
                  + "\n---------------------------------";
    }
    /**
     * displays the display menu view
     */
    public void displayHelpMenuView() {
        
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
            }
            
            break;
        }
        
        return value;
        
    }

    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "O": // View objective of the game
                this.viewObjective();
                break;
            case "F": // display help about fuel
                this.aboutFuel();
                break;
            case "B": // display help about bait
                this.aboutBait();
                break;
            case "C": // display help on casting a line
                this.castLine();
                break;
            case "I": // display help on interpret clues
                this.interpretClues();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
       
        return false;
    }

    private void viewObjective() {
        System.out.println("*** viewObjective function called ***");
    }

    private void aboutFuel() {
        System.out.println("*** aboutFuel function called ***");
    }

    private void aboutBait() {
        System.out.println("*** aboutBait function called ***");
    }

    private void castLine() {
        System.out.println("*** castLine function called ***");
    }
    
    private void interpretClues() {
        System.out.println("*** interpretClues function called ***");
    }
}
