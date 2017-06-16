/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

/**
 *
 * @author Cody
 */
public class StartNewGameView extends View {
    
    public StartNewGameView() {
        super("\n"
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
                  + "\n---------------------------------");
    }

   
    @Override
    public boolean doAction(String choice) {
        
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
        
       shopMarinaView.display(); 
    }

    private void viewInventory() {
        ViewInventoryView viewInventoryView = new ViewInventoryView();
        
        viewInventoryView.displayViewInventoryView();
    }
    
    private void launchBoat() {
        GameMenuView gameMenuView = new GameMenuView();
        gameMenuView.display();
    }

    private void displayHelpMenu() {
        
        HelpMenuView helpMenuView = new HelpMenuView();
        
        helpMenuView.display();
    }

    private void saveGame() {
        System.out.println("*** saveGame function called ***");
    }
    
}
