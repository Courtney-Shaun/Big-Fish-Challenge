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
 * @author Cody
 */
public class MainMenuView {
    
    private String menu;
    
    
    public MainMenuView() {
        this.menu = "\n"
                  + "\n--------------------------------"
                  + "\n Main Menu                     |"
                  + "\n--------------------------------"
                  + "\nN - Start New Game"
                  + "\nL - Load Game"
                  + "\nH - Get help on how to play the game"
                  + "\nS - Save Game"
                  + "\nQ - Quit"
                  + "\n---------------------------------";
    }
    /**
     * displays the display menu view
     */

    public void displayMainMenuView() {
        
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
            
            if (value.length() < 1) { //blank value entered
                System.out.println("\nInvalid value: value can not be blank.");
                continue;
            }
            
            break;
        }
        
        return value; // return the name
        
    }

    private boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "N": // create and start a new game
                this.startNewGame();
                break;
            case "L": // get and start an existing game
                this.startExistingGame();
                break;
            case "H": // display the help menu
                this.displayHelpMenu();
                break;
            case "S": // save the current game
                this.saveGame();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void startNewGame() {
        //create a new game
        GameControl.createNewGame(BigFishChallenge.getPlayer());
        
        // display the game menu
        StartNewGameView startNewGameView = new StartNewGameView();
        startNewGameView.displayStartNewGameView();
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.displayHelpMenuView();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
    
}
