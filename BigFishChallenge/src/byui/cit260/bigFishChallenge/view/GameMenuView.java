/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.control.MapControl;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.model.Location;
import byui.cit260.bigFishChallenge.model.Map;

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
            + "\nD - Display Map"
            + "\nM - Move to New Location"
            + "\nC - Cast a Line"
            + "\nE - Estimate Fuel Usage"
            + "\nT - Talk to Others"
            + "\nB - Buy Bait'n'fuel"
            + "\nV - View Inventory"
            + "\nH - Help Menu"
            + "\nS - Save Game"
            + "\nQ - Quit Game");

    }
        
    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case
        
        switch (value) {
            case "D":
                this.displayMap();
                break;
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
            case "B":
                this.buyBaitNFuel();
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
    
    private void displayMap() {
        
        String leftIndicator;
        String rightIndicator;

        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        Location[][] locations = map.getLocations(); // retreive the locations from map
        // Build the heading of the map
        System.out.print("  |");
        for( int column = 0; column < locations[0].length; column++){
            // print col numbers to side of map
            System.out.print("  " + column + "   |"); 
        }
        // Now build the map.  For each row, show the column information
        System.out.println();
        for( int row = 0; row < locations.length; row++){
            System.out.print(row + " "); // print row numbers to side of map
                for( int column = 0; column < locations[row].length; column++){
                    // set default indicators as blanks
                    leftIndicator = " ";
                    rightIndicator = " ";
                    if(locations[row][column] == map.getCurrentLocation()){
                        // Set star indicators to show this is the current location.
                        leftIndicator = "*"; 
                        rightIndicator = "*"; 
                    } 
                    else if(locations[row][column].isVisited()){
                        // Set < > indicators to show this location has been visited.
                        leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                        rightIndicator = "<"; // same as above
                    }
                 System.out.print("|"); // start map with a |
                  if(locations[row][column].getScene() == null)
                  {
                        // No scene assigned here so use ?? for the symbol
                        System.out.print(leftIndicator + "??" + rightIndicator);
                  }
                  else
                    System.out.print(leftIndicator
                        + locations[row][column].getScene().getMapSymbol()
                        + rightIndicator);
            }
        System.out.println("|");
        }
        System.out.println("\n You are now " + map.getCurrentLocation().getScene().getName());
        System.out.println(map.getCurrentLocation().getScene().getDescription());
    }
    
    private void moveLocations() {
        
        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        
        displayMap();
        int row = getIntInput("\n Row? (-999 to cancel)", 4, 0);
        if (row == -999) {
            return;
        }
        int column = getIntInput("\n Column? (-999 to cancel)", 4, 0);
        if (column == -999) {
            return;
        }
        MapControl.movePlayer(map,row,column);
        //this is where we need to call the scene view associated with the new location
        displayMap();
        
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
        System.out.println("VIEW INVENTORY CALLED");
        
        StringBuilder line;
        
        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        System.out.println("\n     LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                              ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        System.out.println(line.toString());
        
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                              ");
            line.insert(0, item.getItemType());
            line.insert(23, item.getRequiredAmount());
            line.insert(33, item.getQuantityInStock());
            
            System.out.println(line.toString());
        }
    }
    
    private void buyBaitNFuel() {
        ShopMarinaView shopMarinaView = new ShopMarinaView();
        shopMarinaView.display();
    }
    
    private void help() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    private void saveGame() {
        System.out.println("*** startExistingGame function called ***");
    }
        
}