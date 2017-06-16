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
                  + "\nB - Buy bait"
                  + "\nF - Buy fuel"
                  + "\nS - Sell fish"
                  + "\nC - Can you carry your purchases?"
                  + "\nQ - Quit"
                  + "\n---------------------------------");
    }
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "B": // buy bait
                this.buyBait();
                break;
            case "F": // buy fuel
                this.buyFuel();
                break;
            case "S": // sell fish
                this.sellFish();
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

    private void buyBait() {
        System.out.println("*** buyBait function called ***");
    }

    private void buyFuel() {
        System.out.println("*** buyFuel function called ***");
    }

    private void sellFish() {
        System.out.println("*** sellFish function called ***");
    }
    private void carryPurchase() {
        CarryWeightView carryWeightView = new CarryWeightView();
        
        carryWeightView.display();
    }
    
    
}

