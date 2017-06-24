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
import byui.cit260.bigFishChallenge.model.Map;

/**
 *
 * @author Cody
 */

public class CastALineView extends View{
    
    public int weight;
    
    public CastALineView(String fishWeightText, int weight) {
        super("\n"
            + "\n------------------------------------------------"
            + "\n| You've cast your line in the water           |"
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
        
        if("1".equals(choice) || "2".equals(choice) || "3".equals(choice) || "4".equals(choice) || "5".equals(choice) || "6".equals(choice) || "7".equals(choice) || "8".equals(choice) || "9".equals(choice) || "10".equals(choice)) {
            //choice = choice.toUpperCase(); // convert choice to upper case
            int choiceInt = Integer.parseInt(choice);
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
        } else {
            System.out.println("\nInvalid entry.");
            this.display();
        }
        
        return true;
    }

    private void fishCaught(int weight) {
        System.out.println("You caught a " + weight + " pound fish!");
        GameControl.addFish(weight);
        int totalWeight = GameControl.checkFish();
        System.out.println("\n You have " + totalWeight + " total pounds of fish.");
        return; 
    }

    private void fishGotAway() {
        System.out.println("Better luck next time. It got away.");
        int totalWeight = GameControl.checkFish();
        System.out.println("\n You have " + totalWeight + " total pounds of fish.");
        return; 
    }

    
}
