/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.model.Player;
import java.util.Scanner;


public class StartProgramView extends View {
    
    public StartProgramView() {
        super("\nPlease enter your name: ");
        
        this.displayBanner();
    }

    private void displayBanner() {
        this.console.println(
        "\n***************************************************"
        +"\n*                                                 *"
        +"\n*             BIG FISH CHALLENGE                  *"
        +"\n*                                                 *"
        +"\n*                   /`-._                         *"
        +"\n*                  /_,.._`:-                      *"
        +"\n*              ,.-'  ,   `-:..-')                 *"
        +"\n*             : o ):';      _  {                  *"
        +"\n*              `-._ `'__,.-'\\`-.)                 *"
        +"\n*                  `\\\\  \\,.-'`                    *"
        +"\n*                                                 *"
        +"\n* The Annual Fishing Championship has arrived in  *"
        +"\n* Arkansas. It's time for you to get your line in *"
        +"\n* the water and prove that you've got what it     *"
        +"\n* takes to be a champion!                         *"
        +"\n*                                                 *"
        +"\n* Spend your money on bait and fuel and get out   *"
        +"\n* on the water. Try fishing all over the lake,    *"
        +"\n* but keep an eye on your resources. You'll have  *"
        +"\n* to head back to the marina to stock up.         *"
        +"\n*                                                 *"
        +"\n* As you try your luck around the lake, be sure   *"
        +"\n* to talk to other fishermen, who can give you    *"
        +"\n* pointers on where to find the 'big ones'.       *"
        +"\n*                                                 *"
        +"\n*       Be safe, and good luck out there!         *"
        +"\n*                                                 *"
        +"\n***************************************************"
        );
        
    }
    

    @Override
    public boolean doAction(String playersName) {
        
     
        if (playersName.length() < 2) {
            ErrorView.display(this.getClass().getName(),"\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if(player == null) { // if unsuccessful
            ErrorView.display(this.getClass().getName(),"\nError creating the player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; //success!
    }

    private void displayNextView(Player player) {
        // display custom welcome message
        this.console.println("\n============================================="
                         + "\n Welcome to Big Fish Challenge " + player.getName()
                         + "\n We hope you have BOAT loads o' fun!"
                         + "\n============================================="
                         );
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
        
        // Display the main menu view 
        mainMenuView.display();
    }
    
        
}
