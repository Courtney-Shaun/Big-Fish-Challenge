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
public class MainMenuView extends View{
    
    public MainMenuView() {
        super("\n--------------------------------"
              + "\n Main Menu                     |"
              + "\n--------------------------------"
              + "\nN - Start New Game"
              + "\nL - Load Game"
              + "\nH - Get help on how to play the game"
              + "\nS - Save Game"
              + "\nQ - Quit"
              + "\n---------------------------------");
    }
    
    @Override
    public boolean doAction(String value) {
        
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
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
        startNewGameView.display();
    }

    private void startExistingGame() {
        System.out.println("*** startExistingGame function called ***");
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.display();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
    
}
