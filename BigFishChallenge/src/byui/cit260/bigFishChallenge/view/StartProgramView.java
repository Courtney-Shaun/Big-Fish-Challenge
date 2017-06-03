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
    /**
     * displays the start program view
     */
    public void displayStartProgramView() {
        
        
        boolean done = false; // set flag to not done
        do {
            // prompt for and get players name
            String playersName = this.getPlayersName();
            if(playersName.toUpperCase().equals("Q")) // user wants to quit
                return; //exit game
            
            // do the requested action and display next view
            done = this.doAction(playersName);
            
        } while (!done);
        
    }

    private String getPlayersName() {
        /*
        WHILE valid value has not been entered
            DISPLAY promptMessage
            GET the value entered from keyboard
            Trim front and trailing blanks off of the name
            
            IF the length of the value is blank THEN
                DISPLAY "Invalid value: The value can not be blank"
                CONTINUE
            ENDIF
        
            BREAK
        ENDWHILE
        RETURN name
        */
        Scanner keyboard = new Scanner(System.in); // get value from keyboard
        String value = ""; // value to be returned
        boolean valid = false; // initialize to not valid
        
        while (!valid) { // loop while an invalid value is entered
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // get next line typed on keyboard
            value = value.trim(); // trim off leading and trailing blanks
            
            if (value.length() < 1) { // value is blank
                System.out.println("\nInvalid value: value can not be blank.");
                continue;
            }
            
            break; // end the loop
        }
        
        return value; // return the value entered
    }

    private boolean doAction(String playersName) {
        
        /* 
        BEGIN
            IF the length of the playersName < 2 THEN
                DISPLAY "Invalid name: The name must be > 1 character"
                RETURN false
        
            create Player with specified name
            IF unsuccessful THEN
                DISPLAY "Invalid name: The name is too short"
                RETURN false
        
            DISPLAY customized welcome message
            DISPLAY mainMenuView
            RETURN true
        END
        */
        if (playersName.length() < 2) {
            System.out.println("\nInvalid players name: "
                    + "The name must be greater than one character in length");
            return false;
        }
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if(player == null) { // if unsuccessful
            System.out.println("\nError creating the player.");
            return false;
        }
        
        // display next view
        this.displayNextView(player);
        
        return true; //success!
    }

    private void displayNextView(Player player) {
        // display custom welcome message
        System.out.println("\n============================================="
                         + "\n Welcome to Big Fish Challenge " + player.getName()
                         + "\n We hope you have BOAT loads o' fun!"
                         + "\n============================================="
                         );
        // Create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
        
        // Display the main menu view 
        mainMenuView.displayMainMenuView();
    }
    
        
}
