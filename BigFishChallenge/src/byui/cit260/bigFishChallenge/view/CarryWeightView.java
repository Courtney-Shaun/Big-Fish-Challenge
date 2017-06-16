/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import java.util.Scanner;
import byui.cit260.bigFishChallenge.control.PlayerControl;

/**
 *
 * @author Kelly Huber
 */

public class CarryWeightView extends View{
    
  
    private String fuelWeight;
    private String baitweight;
    
    public CarryWeightView() { 
        super("\n"
                  + "\n------------------------------------------------"
                  + "\n You've purchased fuel and bait           "
                  + "\n------------------------------------------------"
                  + "\n"
                  + "\n  Answer the questions to determine"
                  + "\n  if you have enough strength. "  
                  + "\n------------------------------------------------");
     
       
    }
    /**
     * displays the display carryWeight view
     */
    @Override
    public void display() { 
        System.out.println(displayMessage); 
        boolean done = false; // set flag to not done
        do {
            //prompt 
            //String input = this.getInputOne();
            int input = getIntInput("\n How much fuel did you buy?", 50, 1);
            if (input == -999) // user wants to quit
                return; // exit the game
            
            //String inputTwo = this.getInputTwo();
            int inputTwo = getIntInput("\n How much bait did you buy?", 50, 1);
            if (inputTwo == -999) // user wants to quit
                return; // exit the game

            //do the requested action and display the next view
            done = this.doAction(input, inputTwo);
            
        } while (!done);
    }
    
//    public String getInput(String question, int maxVal, int minVal) {
//    
//        Scanner keyboard = new Scanner(System.in); //get infile for keyboard
//        String selection = null;
//        boolean valid = false; 
//        
//        while (!valid) { // loop WHILE a value has not been entered
//            System.out.println("\n" + this.menu); //DISPLAY menu prompt
//            System.out.println(question);
//            
//            selection = keyboard.nextLine();//GET the value from the key board
//            selection = selection.trim(); //trim front and trailing blanks off the value
//            
//            if (selection.length() < 1) { //IF the length of the value is blank THEN
//                System.out.println("\nInvalid value: value can not be blank."); //DISPLAY "Invalid value..."
//                continue;
//            } else if ("q".equals(selection)) {
//                return selection;
//            } else if (Integer.parseInt(selection) > maxVal || (Integer.parseInt(selection) < minVal)) {
//              
//                System.out.println("\n***Invalid value*** Try again."); //DISPLAY "Invalid value..."
//                continue;
//            }
//            
//        break; //end the loop
//        }
//        
//        return selection; //return the value entered
//    
//   }
    
    

    public boolean doAction(int input, int inputTwo) {
        
        //choice = choice.toUpperCase(); // convert choice to upper case
        int fuelWeight = input;
        int baitWeight = inputTwo;
        int strengthRemaining; 
        
        
        PlayerControl playerControl = new PlayerControl();
        
        strengthRemaining = playerControl.carryWeight(fuelWeight,baitWeight); 
        
        if (strengthRemaining < 1) { 
            this.noStrength();
            return false;
        } else {
            this.enoughStrength();
        }
        
        return true;
    }
    private void noStrength() {
        System.out.println("\n You do not have enough strength to carry your supplies!");
    }

    private void enoughStrength() {
        System.out.println("\n You can carry your supplies back to your boat!");
    }
    @Override
    public boolean doAction(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


    