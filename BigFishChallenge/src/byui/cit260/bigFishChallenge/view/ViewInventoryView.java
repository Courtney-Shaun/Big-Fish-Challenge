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
public class ViewInventoryView extends View {
    
    public ViewInventoryView() {
        super("\n"
              + "\n--------------------------------"
              + "\n Inventory Menu                     |"
              + "\n--------------------------------"
              + "\nB - View how much bait you have."
              + "\nF - View how much fuel you have."
              + "\nC - View the number of pounds of fish caught."
              + "\nE - Estimate the amount of fuel needed."
              + "\nH - Get Help"
              + "\nQ - Quit"
              + "\n---------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
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
                ErrorView.display(this.getClass().getName(),"*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void viewBait() {
        this.console.println("*** viewBait function called ***");
    }

    private void viewFuel() {
        this.console.println("*** viewFuel function called ***");
    }

    private void viewFish() {
        this.console.println("*** viewFish function called ***");
    }

    private void estimateFuelNeeded() {
        
        EstimateFuelView estimateFuelView = new EstimateFuelView();
        
        estimateFuelView.display();
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.display();
    }

            
}
