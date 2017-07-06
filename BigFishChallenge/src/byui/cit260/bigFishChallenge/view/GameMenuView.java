/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.control.MapControl;
import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import byui.cit260.bigFishChallenge.model.Actor;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.model.Location;
import byui.cit260.bigFishChallenge.model.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import static oracle.jrockit.jfr.events.Bits.intValue;

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
            + "\nF - Check how much fish you have"
            + "\nE - Estimate Fuel Usage"
            + "\nT - Talk to Others"
            + "\nP - Display people in the game"
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
            {
                try {
                    this.moveLocations();
                } catch (PlayerControlException ex) {
                    this.console.println(ex.getMessage());;
                }
            }
                break;
            case "C":
                this.cast();
                break;
            case "F":
                this.check();
                break;
            case "E":
                this.estimateFuel();
                break;
            case "P":
                this.DisplayPeople();
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
                ErrorView.display(this.getClass().getName(),"/n*** Invalid selection *** Try again");
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
        this.console.print("  |");
        for( int column = 0; column < locations[0].length; column++){
            // print col numbers to side of map
            this.console.print("  " + column + "   |"); 
        }
        // Now build the map.  For each row, show the column information
        this.console.println();
        for( int row = 0; row < locations.length; row++){
            this.console.print(row + " "); // print row numbers to side of map
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
                 this.console.print("|"); // start map with a |
                  if(locations[row][column].getScene() == null)
                  {
                        // No scene assigned here so use ?? for the symbol
                        this.console.print(leftIndicator + "??" + rightIndicator);
                  }
                  else
                    this.console.print(leftIndicator
                        + locations[row][column].getScene().getMapSymbol()
                        + rightIndicator);
            }
        this.console.println("|");
        }
        
        this.console.println("\n You are now " + map.getCurrentLocation().getScene().getName());
        this.console.println(map.getCurrentLocation().getScene().getDescription());
    }
    
    private void moveLocations() throws PlayerControlException {
        
        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        
        displayMap();
        
        this.console.println("You have " + game.getFuel() + " gallons of fuel.");
        
        int row = getIntInput("\n Row? (-999 to cancel)", 4, 0);
        if (row == -999) {
            return;
        }
        int column = getIntInput("\n Column? (-999 to cancel)", 4, 0);
        if (column == -999) {
            return;
        }
        
        double destRow = map.getCurrentLocation().getRow();
        double destColumn = map.getCurrentLocation().getColumn();
        //FUEL ALGORITHM TO DETERMINE IF YOU REACH DESTINATION HERE
        
        //System.out.println("row " + destRow + " column " + destColumn + "THIS IS THE LOCATION!");
        double distance = Math.sqrt(Math.pow(Math.abs(destRow - row), 2) + (Math.pow(Math.abs(destColumn - column), 2)));
        
        int gallons = game.getFuel();
        if (gallons == 0) {
            this.console.println("You must buy fuel before you can move.");
            return;
        }
        
        int gallonsLeft = intValue(PlayerControl.estimateFuel(distance, gallons));

        MapControl.movePlayer(map,row,column);
        //this is where we need to call the scene view associated with the new location

        game.setFuel(gallonsLeft);

        displayMap();

    }
    
    private void cast() {
        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        
        int weight = map.getCurrentLocation().getScene().getFishWeight(); //retrieve fish weight from scene
        
               
        String fishWeightText;
        if (weight == -1) {
            this.console.println("\n"
            + "\n------------------------------------------------"
            + "\n| Sorry, but you can't fish here               |"
            + "\n------------------------------------------------");
            return;
        } else if (game.getBait() < 1) {
            this.console.println("\n"
            + "\n------------------------------------------------"
            + "\n| You don't have any bait.                    |"
            + "\n| Go back to the marina to buy more.           |"
            + "\n------------------------------------------------");
            return;
        } else if (weight == 0) {
            game.setBait(game.getBait() - 1); 
            this.console.println("\n"
            + "\n------------------------------------------------"
            + "\n| You didn't get any bites."
            + "\n| You have " + game.getBait() + " pounds of bait left."
            + "\n------------------------------------------------");
                       
            return;
        } else if (weight < 11 && weight > 0) {
            fishWeightText = "You felt a little tug on your line.";
        } else {
            fishWeightText = "You felt a strong tug on your line!";
        }
        game.setBait(game.getBait() - 1);
        CastALineView castALineView = new CastALineView(fishWeightText, weight, game.getBait());
        castALineView.display();
    }
    
    public static void check() {
        int totalWeight = GameControl.checkFish();
        int totalFish = GameControl.checkNumFish();
        if (totalFish == 1) {
            System.out.println("\n You have " + totalFish + " fish that weighs " + totalWeight + " pounds.");
        } else {
            System.out.println("\n You have " + totalFish + " fish that weigh a combined " + totalWeight + " pounds.");
        }
        
    }
    
    private void estimateFuel() {
        EstimateFuelView estimateFuelView = new EstimateFuelView();
        estimateFuelView.display();
    }
    
    private void talkToOthers() {
        this.console.println("*** talktoothers() function called ***");
    }
    
    private void viewInventory() {
        this.console.println("VIEW INVENTORY CALLED");
        
        StringBuilder line;
        
        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();
        
        this.console.println("\n     LIST OF INVENTORY ITEMS");
        line = new StringBuilder("                              ");
        line.insert(0, "DESCRIPTION");
        line.insert(20, "REQUIRED");
        line.insert(30, "IN STOCK");
        this.console.println(line.toString());
        
        for (InventoryItem item : inventory) {
            line = new StringBuilder("                              ");
            line.insert(0, item.getItemType());
            line.insert(23, item.getRequiredAmount());
            line.insert(33, item.getQuantityInStock());
            
            this.console.println(line.toString());
        }
    }
    
    private void buyBaitNFuel() {
        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        
        String symbol = map.getCurrentLocation().getScene().getMapSymbol();
        this.console.println(symbol);
        if (symbol != " MR ") {
            this.console.println("You can't buy anything here! Go to the marina to buy something.");
        } else {        
            ShopMarinaView shopMarinaView = new ShopMarinaView();
            shopMarinaView.display();
        }
    }
    
    private void help() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
    
    private void saveGame() {
        this.console.println("*** startExistingGame function called ***");
    }
    
    private void DisplayPeople() {
        Actor youngestActor = Actor.NoActor;
        Actor oldestActor = Actor.NoActor;
         
        this.console.println("\n     LIST OF PEOPLE");
        StringBuilder line;
        line = new StringBuilder("                              ");
        line.insert(0, "Name");
        line.insert(20, "Age");
        
        this.console.println(line.toString());
         for (Actor currentActor:Actor.values()) {
             if (currentActor != Actor.NoActor) {
                 if (youngestActor == Actor.NoActor || currentActor.getAge()< youngestActor.getAge())
                     youngestActor = currentActor;
                 if (oldestActor == Actor.NoActor || currentActor.getAge()> oldestActor.getAge())
                     oldestActor = currentActor;
                line = new StringBuilder("                              ");
                line.insert(0, currentActor.getName());
                line.insert(20, currentActor.getAge());
                this.console.println(line.toString());
             }
             
         }
         this.console.println("\nThe oldest person is " + oldestActor.getName());
         this.console.println("The youngest person is " + youngestActor.getName());
     }   
}
