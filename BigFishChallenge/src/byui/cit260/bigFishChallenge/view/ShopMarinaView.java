/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;

/**
 *
 * @author Kelly Huber
 */
public class ShopMarinaView extends View {
    
   
    
    
    public ShopMarinaView() {
        super("\n"
                  + "\n--------------------------------"
                  + "\n  Welcome to the Marina!"
                  + "\n  Purchase bait and fuel here."
                  + "\n  Be sure purchases are not"
                  + "\n  too heavy so you can carry "
                  + "\n  them back to the boat. "
                  + "\n--------------------------------"
                  + "\nB - Buy supplies"
                  + "\nQ - Quit"
                  + "\n---------------------------------");
    }
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "B": {
            try {
                // buy bait
                this.buySupplies();
                    } catch (PlayerControlException ex) {
                        this.console.println(ex.getMessage());
                    }
                }
                break;
            
            default:
                ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void buySupplies() throws PlayerControlException {
        int pricePerPound = 5;
        int pricePerGallon = 4;
        
        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventoryList = game.getInventory();
        
        int bait = inventoryList[GameControl.Item.bait.ordinal()].getQuantity();
        int fuel = inventoryList[GameControl.Item.fuel.ordinal()].getQuantity();
        int money = inventoryList[GameControl.Item.money.ordinal()].getQuantity();
        
        this.console.println("You currently have " + bait + " pounds of bait and " + fuel + " gallons of fuel.");
        this.console.println("Bait is $" + pricePerPound + " per pound.");
        this.console.println("Fuel is $" + pricePerGallon + " per gallon.");
        this.console.println("You have $" + money + ".");
        int pounds = getIntInput("How many pounds of bait would you like to buy?", 50, 0);
        int gallons = getIntInput("How many gallons of fuel would you like to buy?", 50, 0);
        
        int totalPrice = (pricePerPound * pounds) + (pricePerGallon * gallons);
        
        if (PlayerControl.carryWeight(pounds, gallons) < 1) {
            this.console.println("You can't carry this much. It's too heavy!");
        } else if (totalPrice <= money) {
            inventoryList[GameControl.Item.money.ordinal()].setQuantity(money - totalPrice);
            inventoryList[GameControl.Item.bait.ordinal()].setQuantity(bait + pounds);
            inventoryList[GameControl.Item.fuel.ordinal()].setQuantity(fuel + gallons);
            this.console.println("You just bought " + pounds + " pounds of bait, and " + gallons + " gallons of fuel.");
            this.console.println("You have $" + (money - totalPrice) + " left.");
        } else {
            this.console.println("You don't have enough money for this.");
        }
    }
}

