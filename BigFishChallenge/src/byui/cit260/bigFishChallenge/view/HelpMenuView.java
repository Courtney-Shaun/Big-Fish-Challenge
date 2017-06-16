/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;

/**
 *
 * @author Group
 */
public class HelpMenuView  extends View{
    
    public HelpMenuView() {
        super("\n"
              + "\n--------------------------------"
              + "\n Help Menu                     |"
              + "\n--------------------------------"
              + "\nO - Objective of the game"
              + "\nF - About Fuel"
              + "\nB - About Bait"
              + "\nC - Casting a Line"
              + "\nI - Interpreting Clues"
              + "\nQ - Quit"
              + "\n---------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
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
                this.aboutCastLine();
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

    private void aboutCastLine() {
        System.out.println("*** aboutCastLine function called ***");
    }
    
    private void interpretClues() {
        System.out.println("*** interpretClues function called ***");
    }
}
