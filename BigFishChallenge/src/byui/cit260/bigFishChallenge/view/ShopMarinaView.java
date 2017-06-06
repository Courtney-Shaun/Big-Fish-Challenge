/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.control.GameControl;
import java.util.Scanner;
/**
 *
 * @author Kelly Huber
 */
public class ShopMarinaView {
    
    private String menu;
    
    
    public ShopMarinaView() {
        this.menu = "\n"
                  + "\n--------------------------------"
                  + "\n  Welcome to the Marina!"
                  + "\n  Purchase bait and fuel here."
                  + "\n  Be sure purchases are not"
                  + "\n  too heavy so you can carry "
                  + "\n  them back to the boat. "
                  + "\n  Sell the fish you catch here"
                  + "\n  at the Marina if you wish."
                  + "\n--------------------------------"
                  + "\nB - Buy bait"
                  + "\nF - Buy fuel"
                  + "\nS - Sell fish"
                  + "\nQ - Quit"
                  + "\n---------------------------------";
    }
    /**
     * displays the display shop marina view
     */

    public void displayShopMarinaView() {
        
        boolean done = false; // set flag to not done
        do {
            //prompt 
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
            case "B": // buy bait
                this.buyBait();
                break;
            case "F": // buy fuel
                this.buyFuel();
                break;
            case "S": // sell fish
                this.sellFish();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void buyBait() {
        System.out.println("*** buyBait function called ***");
    }

    private void buyFuel() {
        System.out.println("*** buyFuel function called ***");
    }

    private void sellFish() {
        System.out.println("*** sellFish function called ***");
    }

    
    
}

