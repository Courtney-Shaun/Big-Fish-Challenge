/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.PlayerControl;

/**
 *
 * @author Cody
 */

public class CastALineView extends View{
    
    private int weight;
    
    public CastALineView(String fishWeightText, int weight) {
        super("\n"
            + "\n------------------------------------------------"
            + "\n| You've cast your line in the water           |"
            + "\n------------------------------------------------"
            + "\n"
            + "\n  You just felt a" + fishWeightText + "tug!"
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
                this.fishCaught();
            } else {
                this.fishGotAway();
            }
        } else {
            System.out.println("\nInvalid entry.");
            this.display();
        }
        
        return true;
    }

    private void fishCaught() {
        System.out.println("*** fishCaught function called ***");
        return; 
    }

    private void fishGotAway() {
        System.out.println("*** fishGotAway function called ***");
        return; 
    }

    
}
