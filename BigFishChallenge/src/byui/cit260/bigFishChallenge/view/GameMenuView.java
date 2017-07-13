/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.control.GameControl.Item;
import byui.cit260.bigFishChallenge.control.MapControl;
import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import byui.cit260.bigFishChallenge.model.Actor;
import static oracle.jrockit.jfr.events.Bits.intValue;
import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.model.Location;
import byui.cit260.bigFishChallenge.model.Map;
import java.io.FileOutputStream;
import java.io.PrintWriter;

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
                + "\nP - Display people in the game"
                + "\nR - Save report for people in the game"
                + "\nB - Buy Bait'n'fuel"
                + "\nV - View Inventory"
                + "\nI - Save Inventory Report"
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
            case "M": {
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
            case "P":
                this.DisplayPeople();
                break;
            case "R":
                this.PrintDisplayPeople();
                break;
            case "B":
                this.buyBaitNFuel();
                break;
            case "V":
                this.viewInventory();
                break;
            case "I":
                this.printInventory();
                break;
            case "H":
                this.help();
                break;
            case "S":
                this.saveGame();
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
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
        for (int column = 0; column < locations[0].length; column++) {
            // print col numbers to side of map
            this.console.print("  " + column + "   |");
        }
        // Now build the map.  For each row, show the column information
        this.console.println();
        for (int row = 0; row < locations.length; row++) {
            this.console.print(row + " "); // print row numbers to side of map
            for (int column = 0; column < locations[row].length; column++) {
                // set default indicators as blanks
                leftIndicator = " ";
                rightIndicator = " ";
                if (locations[row][column] == map.getCurrentLocation()) {
                    // Set star indicators to show this is the current location.
                    leftIndicator = "*";
                    rightIndicator = "*";
                } else if (locations[row][column].isVisited()) {
                    // Set < > indicators to show this location has been visited.
                    leftIndicator = ">"; // can be stars or whatever these are indicators showing visited
                    rightIndicator = "<"; // same as above
                }
                this.console.print("|"); // start map with a |
                if (locations[row][column].getScene() == null) {
                    // No scene assigned here so use ?? for the symbol
                    this.console.print(leftIndicator + "??" + rightIndicator);
                } else {
                    this.console.print(leftIndicator
                            + locations[row][column].getScene().getMapSymbol()
                            + rightIndicator);
                }
            }
            this.console.println("|");
        }

        this.console.println("\n You are now " + map.getCurrentLocation().getScene().getName());
        this.console.println(map.getCurrentLocation().getScene().getDescription());
    }

    private void moveLocations() throws PlayerControlException {

        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        InventoryItem[] inventoryList = game.getInventory();
        
        int fuel = inventoryList[Item.fuel.ordinal()].getQuantity();
        int fishWeight = inventoryList[Item.fish.ordinal()].getWeight();
        
        displayMap();

        //this.console.println("You have " + game.getFuel() + " gallons of fuel.");
        this.console.println("You have " + fuel + " gallons of fuel.");

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

        
        if (fuel == 0) {
            if (row == 4 && column == 2) {
                this.console.println("You must buy fuel before you can move.");
                return;
            } else {
                LoseGameView loseGameView = new LoseGameView();
                loseGameView.display();
            }
            
        }

        int gallonsLeft = intValue(PlayerControl.estimateFuel(distance, fuel));

        MapControl.movePlayer(map, row, column);
        //this is where we need to call the scene view associated with the new location
        //this.console.println(destRow + " " + destColumn + " " + fishWeight);
        if (row == 4 && column == 2 && fishWeight >= 50){
            //winGame();
            WinGameView winGameView = new WinGameView();
            winGameView.display();
        } else {
            inventoryList[Item.fuel.ordinal()].setQuantity(gallonsLeft);
                        
            displayMap();
            
            if (map.getCurrentLocation().getScene().getActor() != null) {
                Actor currentActor = map.getCurrentLocation().getScene().getActor();
                
                this.console.println("\n-------------------------"
                        + "\n" + currentActor.getName() + " is here."
                        + "\n-------------------------"
                        + "\n'" + currentActor.getClue() + "'");
            }
        }

    }

    private void cast() {
        Game game = BigFishChallenge.getCurrentGame(); // retreive the game
        Map map = game.getMap(); // retreive the map from game
        InventoryItem[] inventoryList = game.getInventory();
        
        int bait = inventoryList[Item.bait.ordinal()].getQuantity();
        
        int weight = map.getCurrentLocation().getScene().getFishWeight(); //retrieve fish weight from scene

        String fishWeightText;
        if (weight == -1) {
            this.console.println("\n"
                    + "\n------------------------------------------------"
                    + "\n| Sorry, but you can't fish here               |"
                    + "\n------------------------------------------------");
            return;
        } else if (bait < 1) {
            this.console.println("\n"
                    + "\n------------------------------------------------"
                    + "\n| You don't have any bait.                    |"
                    + "\n| Go back to the marina to buy more.           |"
                    + "\n------------------------------------------------");
            return;
        } else if (weight == 0) {
            inventoryList[Item.bait.ordinal()].setQuantity(bait - 1);
            this.console.println("\n"
                    + "\n------------------------------------------------"
                    + "\n| You didn't get any bites."
                    + "\n| You have " + (bait - 1) + " pounds of bait left."
                    + "\n------------------------------------------------");

            return;
        } else if (weight < 11 && weight > 0) {
            fishWeightText = "You felt a little tug on your line.";
        } else {
            fishWeightText = "You felt a strong tug on your line!";
        }
        inventoryList[Item.bait.ordinal()].setQuantity(bait - 1);
        CastALineView castALineView = new CastALineView(fishWeightText, weight, (bait - 1));
        castALineView.display();
    }

    public static void check() {
        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventoryList = game.getInventory();
        
        int totalWeight = inventoryList[GameControl.Item.fish.ordinal()].getWeight();
        int totalFish = inventoryList[GameControl.Item.fish.ordinal()].getQuantity();
        if (totalFish == 1) {
            System.out.println("\n You have " + totalFish + " fish that weighs " + totalWeight + " pounds.");
        } else if (totalFish == 0) {
            System.out.println("\n You have " + totalFish + " fish.");
        } else {
            System.out.println("\n You have " + totalFish + " fish that weigh a combined " + totalWeight + " pounds.");
        }

    }

    private void viewInventory() {
        //this.console.println("VIEW INVENTORY CALLED");

        StringBuilder line;

        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventory = game.getInventory();

        this.console.println("\n-----------------------");
        this.console.println("LIST OF INVENTORY ITEMS");
        this.console.println("-----------------------");
        line = new StringBuilder("                              ");
        line.insert(0, "TYPE");
        line.insert(15, "QUANTITY");
        this.console.println(line.toString());
        

        for (InventoryItem item : inventory) {
            line = new StringBuilder("                              ");
            line.insert(0, item.getType());
            line.insert(15, item.getQuantity());

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
        //prompt for and get the name of the file to save the game in
        this.console.println("\n\nEnter the file path for the file where the game "
                            + "is to be saved.");
        String filePath = this.getInput();
        
        try {
            // save the game to the specified file
            GameControl.saveGame(BigFishChallenge.getCurrentGame(), filePath);
        } catch (Exception ex) {
            ErrorView.display("MainMenuView", ex.getMessage());
        }
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
        for (Actor currentActor : Actor.values()) {
            if (currentActor != Actor.NoActor) {
                if (youngestActor == Actor.NoActor || currentActor.getAge() < youngestActor.getAge()) {
                    youngestActor = currentActor;
                }
                if (oldestActor == Actor.NoActor || currentActor.getAge() > oldestActor.getAge()) {
                    oldestActor = currentActor;
                }
                line = new StringBuilder("                              ");
                line.insert(0, currentActor.getName());
                line.insert(20, currentActor.getAge());
                this.console.println(line.toString());
            }

        }
        this.console.println("\nThe oldest person is " + oldestActor.getName());
        this.console.println("The youngest person is " + youngestActor.getName());
    }

    private void PrintDisplayPeople() {
        
        String savePrompt = displayMessage;
        
        displayMessage = "\n\nEnter the file path for the file where the report is to be saved.";
        String filePath = this.getInput();

        try( FileOutputStream fops = new FileOutputStream(filePath)) {
            PrintWriter output = new PrintWriter(fops,true);
        
            Actor youngestActor = Actor.NoActor;
            Actor oldestActor = Actor.NoActor;

            output.println("\n     LIST OF PEOPLE");
            StringBuilder line;
            line = new StringBuilder("                              ");
            line.insert(0, "Name");
            line.insert(20, "Age");

            output.println(line.toString());
            for (Actor currentActor : Actor.values()) {
                if (currentActor != Actor.NoActor) {
                    if (youngestActor == Actor.NoActor || currentActor.getAge() < youngestActor.getAge()) {
                        youngestActor = currentActor;
                    }
                    if (oldestActor == Actor.NoActor || currentActor.getAge() > oldestActor.getAge()) {
                        oldestActor = currentActor;
                    }
                    line = new StringBuilder("                              ");
                    line.insert(0, currentActor.getName());
                    line.insert(20, currentActor.getAge());
                    output.println(line.toString());
                }

            }
            output.println("\nThe oldest person is " + oldestActor.getName());
            output.println("The youngest person is " + youngestActor.getName());

            this.console.println("\nYou successfully saved to file " + filePath);

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "\n*** Error saving to file " + filePath + ". " + e.getMessage());
        }
        displayMessage = savePrompt;
    }

    private void printInventory() {
        String savePrompt = displayMessage;
        
        displayMessage = "\n\nEnter the file path for the file where the report is to be saved.";
        String filePath = this.getInput();
        
               
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            PrintWriter output = new PrintWriter(fops,true);
        
            StringBuilder line;

            Game game = BigFishChallenge.getCurrentGame();
            InventoryItem[] inventory = game.getInventory();

            output.println("\n-----------------------");
            output.println("LIST OF INVENTORY ITEMS");
            output.println("-----------------------");
            line = new StringBuilder("                              ");
            line.insert(0, "TYPE");
            line.insert(15, "QUANTITY");
            output.println(line.toString());


            for (InventoryItem item : inventory) {
                line = new StringBuilder("                              ");
                line.insert(0, item.getType());
                line.insert(15, item.getQuantity());

                output.println(line.toString());
            }
                        
            this.console.println("\nYou successfully saved to file " + filePath);

        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "\n*** Error saving to file " + filePath + ". " + e.getMessage());
        }
        displayMessage = savePrompt;
    }
}
