/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.control.GameControl;
import byui.cit260.bigFishChallenge.model.Player;
import java.util.Scanner;


public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
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

    public void displayStartProgramView() {
        
        
        boolean done = false;
        do {
            String playersName = this.getPlayersName();
            if(playersName.toUpperCase().equals("Q"))
                return;
            
            done = this.doAction(playersName);
            
        } while (!done);
        
    }

    private String getPlayersName() {
        Scanner keyboard = new Scanner(System.in);
        String value = "";
        boolean valid = false;
        
        while (!valid) {
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine();
            value = value.trim();
            
            if (value.length() < 1) {
                System.out.println("\nInvalid value: value can not be blank.");
                continue;
            }
            
            break;
        }
        
        return value;
    }

    private boolean doAction(String playersName) {
        
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        
        Player player = GameControl.createPlayer(playersName);
        
        if(player == null) {
            System.out.println("\nError creating the player.");
            return false;
        }
        
        this.displayNextView(player);
        
        return true;
    }

    private void displayNextView(Player player) {
        System.out.println("\n============================================="
                         + "\n Welcome to Big Fish Challenge " + player.getName()
                         + "\n We hope you have a BOAT loads o' fun!"
                         + "\n============================================="
                         );
        
        MainMenuView mainMenuView = new MainMenuView();
        
        mainMenuView.displayMainMenuView();
    }
    
        
}
