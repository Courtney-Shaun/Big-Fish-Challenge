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
public class GameMenuView extends View {
    
        public GameMenuView() {
        super("\n------------------------------"
            + "\n Game Menu"
            + "\n------------------------------"
            + "\n"
            + "\nM - Move to New Location"
            + "\nC - Cast a Line"
            + "\nE - Estimate Fuel Usage"
            + "\nT - Talk to Others"
            + "\nV - View Inventory"
            + "\nH - Help Menu"
            + "\nS - Save Game"
            + "\nQ - Quit Game");

    }
        
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "M":
                this.moveLocations();
                break;
            case "C":
                this.cast();
                break;
            case "E":
                this.estimateFuel();
                break;
            case "T":
                this.talkToOthers();
                break;
            case "V":
                this.viewInventory();
                break;
            case "H":
                this.help();
                break;
            case "S":
                this.saveGame();
                break;
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }
    
    private void moveLocations() {
        System.out.println("*** startExistingGame function called ***");
    }
    
    private void cast() {
        
        int weight = 5; //eventually the weight will be determined by map location
        String fishWeightText;
        if (weight < 11) {
            fishWeightText = " little ";
        } else {
            fishWeightText = " strong ";
        }
        
        CastALineView castALineView = new CastALineView(fishWeightText, weight);
        castALineView.display();
    }
    
    private void estimateFuel() {
        EstimateFuelView estimateFuelView = new EstimateFuelView();
        estimateFuelView.display();
    }
    
    private void talkToOthers() {
        System.out.println("*** startExistingGame function called ***");
    }
    
    private void viewInventory() {
        ViewInventoryView viewInventoryView = new ViewInventoryView();
        viewInventoryView.display();
    }
    
    private void help() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    private void saveGame() {
        System.out.println("*** startExistingGame function called ***");
    }
        
}
