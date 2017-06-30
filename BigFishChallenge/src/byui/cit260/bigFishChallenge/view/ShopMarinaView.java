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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                  + "\n  Sell the fish you catch here"
                  + "\n  at the Marina if you wish."
                  + "\n--------------------------------"
                  + "\nB - Buy supplies"
                  + "\nC - Can you carry your purchases?"
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
                        System.out.println(ex.getMessage());
                    }
                }
                break;
            case "C": // carryWeight
                this.carryPurchase();
                break;    
            default:
                System.out.println("/n*** Invalid selection *** Try again");
                break;
            
        }
        
        return false;
    }

    private void buySupplies() throws PlayerControlException {
        int pricePerPound = 5;
        int pricePerGallon = 4;
        
        Game game = BigFishChallenge.getCurrentGame();
        
        System.out.println("You currently have " + game.getBait() + " pounds of bait and " + game.getFuel() + " gallons of fuel.");
        System.out.println("Bait is $" + pricePerPound + " per pound.");
        System.out.println("Fuel is $" + pricePerGallon + " per gallon.");
        System.out.println("You have $" + game.getMoney() + ".");
        int pounds = getIntInput("How many pounds of bait would you like to buy?", 50, 0);
        int gallons = getIntInput("How many gallons of fuel would you like to buy?", 50, 0);
        
        int totalPrice = (pricePerPound * pounds) + (pricePerGallon * gallons);
        
        if (PlayerControl.carryWeight(pounds, gallons) < 1) {
            System.out.println("You can't carry this much. It's too heavy!");
        } else if (totalPrice <= game.getMoney()) {
            game.setMoney(game.getMoney() - totalPrice);
            game.setBait(game.getBait() + pounds);
            game.setFuel(game.getFuel() + gallons);
            System.out.println("You just bought " + pounds + " pounds of bait, and " + gallons + " gallons of fuel.");
            System.out.println("You have $" + game.getMoney() + " left.");
        } else {
            System.out.println("You don't have enough money for this.");
        }
    }
    
    private void carryPurchase() {
        CarryWeightView carryWeightView = new CarryWeightView();
        
        carryWeightView.display();
    }
    
    
}

