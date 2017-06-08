/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;

/**
 *
 * @author Shaun Courtney
 */
public class ViewInventoryView {
    
    private String menu;
        
    public ViewInventoryView() {
        this.menu = "\n"
                  + "\n--------------------------------"
                  + "\n Inventory Menu                     |"
                  + "\n--------------------------------"
                  + "\nB - View how much bait you have."
                  + "\nF - View how much fuel you have."
                  + "\nC - View the number of pounds of fish caught."
                  + "\nE - Estimate the amount of fuel needed."
                  + "\nH - Get Help"
                  + "\nQ - Quit"
                  + "\n---------------------------------";
    }
    /**
     * displays the display inventory menu view
     */

    public void displayViewInventoryView() {
        
        boolean done = false; // set flag to not done
        do {
            // Get the menu option
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
            case "B": // view amount of bait in inventory
                this.viewBait();
                break;
            case "F": // view amount of fuel in inventory
                this.viewFuel();
                break;
            case "C": // view number of pounds of fish caught
                this.viewFish();
                break;
            case "E": // estimate needed fuel
                this.estimateFuelNeeded();
                break;
            case "H": // display help menu
                this.displayHelpMenu();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void viewBait() {
        System.out.println("*** viewBait function called ***");
    }

    private void viewFuel() {
        System.out.println("*** viewFuel function called ***");
    }

    private void viewFish() {
        System.out.println("*** viewFish function called ***");
    }

    private void estimateFuelNeeded() {
        
        EstimateFuelView estimateFuelView = new EstimateFuelView();
        
        estimateFuelView.displayEstimateFuelView();
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.displayHelpMenuView();
    }

            
}
