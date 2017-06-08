/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;

/**
 *
 * @author Cody
 */
public class StartNewGameView {
    
    private String menu;
    
    
    public StartNewGameView() {
        this.menu = "\n"
                  + "\n--------------------------------"
                  + "\n You've just pulled your boat"
                  + "\n into Greers Ferry Lake. Its a"
                  + "\n beautiful sunny morning and"
                  + "\n you're excited to get started. Be"
                  + "\n sure to pick up some bait before"
                  + "\n heading out!"
                  + "\n--------------------------------"
                  + "\nM - Enter Marina"
                  + "\nV - View Inventory"
                  + "\nL - Launch Boat"
                  + "\nH - Get help on how to play the game"
                  + "\nS - Save Game"
                  + "\nQ - Quit"
                  + "\n---------------------------------";
    }
    /**
     * displays the display menu view
     */

    public void displayStartNewGameView() {
        
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
            case "M": // enter the marina
                this.enterMarina();
                break;
            case "V": // view inventory
                this.viewInventory();
                break;
            case "L": // launch boat
                this.launchBoat();
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save teh current game
                this.saveGame();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void enterMarina() {
       ShopMarinaView shopMarinaView = new ShopMarinaView();
        
       shopMarinaView.displayShopMarinaView(); 
    }

    private void viewInventory() {
        System.out.println("*** viewInventory() function called ***");
    }
    
    private void launchBoat() {
        System.out.println("*** launchBoat() function called ***");
        
        //the remaining code in this function tests the CastALineView class to fulfill the requirement for the assignment
        int weight = 5;
        String fishWeightText;
        if (weight < 11) {
            fishWeightText = " little ";
        } else {
            fishWeightText = " strong ";
        }
        
        CastALineView castALineView = new CastALineView(fishWeightText, weight);
        castALineView.displayCastView();
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.displayHelpMenuView();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
    
}
