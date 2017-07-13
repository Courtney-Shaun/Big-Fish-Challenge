/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.control.PlayerControl;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.model.Map;

/**
 *
 * @author Cody
 */

public class CastALineView extends View{
    
    public int weight;
    
    public CastALineView(String fishWeightText, int weight, int bait) {
        super("\n"
            + "\n------------------------------------------------"
            + "\n| You've cast your line in the water."
            + "\n| You have " + bait + " pounds of bait left."
            + "\n------------------------------------------------"
            + "\n"
            + "\n  " + fishWeightText
            + "\n"
            + "\n  To set the hook, enter a pull strength (1-10)"
            + "\n------------------------------------------------");
        
        this.weight = weight;
    }
   
    
    @Override
    public boolean doAction(String choice) {
        int choiceInt = 0;
        try {
            choiceInt = Integer.parseInt(choice);
        } catch (NumberFormatException nf) {
            ErrorView.display(this.getClass().getName(),"\nInvalid entry.");
        }
        
        if(1 <= choiceInt && choiceInt < 11) {
                        
            double hookSetAccuracy;
            PlayerControl playerControl = new PlayerControl();
            hookSetAccuracy = playerControl.cast(choiceInt, weight);

            if (hookSetAccuracy < 4) {
                this.fishCaught(weight);
            } else {
                this.fishGotAway();
            }
            
            Game game = BigFishChallenge.getCurrentGame(); // retreive the game
            Map map = game.getMap(); // retreive the map from game
            
            map.getCurrentLocation().getScene().setFishWeight(0);
        } else if (choiceInt <= 0 || 11 <= choiceInt) {
            ErrorView.display(this.getClass().getName(),"\nPlease enter a number between 1 and 10.");
            this.display();
        }
        
        return true;
    }

    private void fishCaught(int weight) {
        Game game = BigFishChallenge.getCurrentGame();
        InventoryItem[] inventoryList = game.getInventory();
        this.console.println("You caught a " + weight + " pound fish!");
        
        //GameControl.addFish(weight);
        int totalFish = inventoryList[GameControl.Item.fish.ordinal()].getQuantity();
        int totalWeight = inventoryList[GameControl.Item.fish.ordinal()].getWeight();


        inventoryList[GameControl.Item.fish.ordinal()].setQuantity(totalFish + 1);
        inventoryList[GameControl.Item.fish.ordinal()].setWeight(totalWeight + weight);

        GameMenuView.check();
        return; 
    }

    private void fishGotAway() {
        this.console.println("Better luck next time. It got away.");
        GameMenuView.check();
        return; 
    }

    
}
