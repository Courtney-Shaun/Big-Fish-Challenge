/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.exceptions.PlayerControlException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;
    
    protected final BufferedReader keyboard = BigFishChallenge.getInFile();
    protected final PrintWriter console = BigFishChallenge.getOutFile();
    
    public View() {
    }
    
    public View(String message) {
        this.displayMessage = message;
    }
    
    @Override
    public void display() {
        
        boolean done = false; // set flag to not done
        do {
            //prompt for and get players name
            String value = this.getInput();
            if (value.toUpperCase().equals("Q")) // user wants to quit
                return; // exit the game
            
            // do the requested action and display the next view
            done = this.doAction(value);
            
        } while (!done);
    }
    
    @Override
    public String getInput() {
        
       
        boolean valid = false;
        String value = null;
        
        // while a valid name has not been retrieved
        while (!valid) {
            
            // prompt for the user input
            this.console.println("\n" + this.displayMessage);
            
            try {
                // get the value entered from the keyboard
                value = this.keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            value = value.trim();
            
            if (value.length() < 1) { //blank value entered
                ErrorView.display(this.getClass().getName(),"\nInvalid value: value can not be blank.");
                continue;
            }
            
            break;
        }
        
        return value; // return the name
        
    }
    @Override
    public int getIntInput(String question, int maxVal, int minVal) {
    
       
        String selection = null;
        boolean valid = false; 
        int selectionInt = 0;
        while (!valid) { // loop WHILE a value has not been entered
            
            this.console.println(question);
            
            try {
                selection = this.keyboard.readLine();//GET the value from the key board
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            selection = selection.trim(); //trim front and trailing blanks off the value
            
            
            
            //if (selection.length() < 1) { //IF the length of the value is blank THEN
            //    System.out.println("\nInvalid value: value can not be blank."); //DISPLAY "Invalid value..."
            //   continue;
            //} else 
            
            if ("Q".equals(selection.toUpperCase())) {
                return -999;
            }
            
            try {
                selectionInt = Integer.parseInt(selection);
                if (selectionInt > maxVal || selectionInt < minVal) {
              
                    ErrorView.display(this.getClass().getName(),
                            "\nThe number should be greater than or equal to " + minVal + " and less than or equal to " + maxVal); //DISPLAY "Invalid value..."
                    continue;
                }
                break; //end the loop
            } catch (NumberFormatException ne){
                ErrorView.display(this.getClass().getName(),
                        "Invalid Value. Try again. It has to be a number. Enter Q to exit.");
            }
        
        }
        
        return selectionInt; //return the value entered
    
   }
    @Override
    public double getDoubleInput(String ask, double maxVal, double minVal) {
        
        
        boolean valid = false;
        double selectionDouble = 0;
        String selection = null;
        
        // while a valid entry has not been retrieved
        while (!valid) {
            
            this.console.println(displayMessage);
            this.console.println(ask);
            
            try {
                // get the value entered from the keyboard
                selection = this.keyboard.readLine();
            } catch (IOException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            selection = selection.trim();
            
//            if (selection.length() < 1) {
//                System.out.println("\n*** Invalid selection *** Try again");
//                continue;
//            } else if ("q".equals(selection)){
//                return -999;
//            } else if (Double.parseDouble(selection) > maxVal || (Double.parseDouble(selection) < minVal)) {
//                System.out.println("\n*** Invalid selection *** Try again");
//                continue;
//            } 
              if ("Q".equals(selection.toUpperCase())) {
                return -999;
            }
            try {
                selectionDouble = Double.parseDouble(selection);
                if (selectionDouble > maxVal || selectionDouble < minVal) {
              
                    ErrorView.display(this.getClass().getName(),"\nThe number should be greater than or equal to " + minVal + " and less than or equal to " + maxVal); //DISPLAY "Invalid value..."
                    continue;
                }
                break; //end the loop
            } catch (NumberFormatException ne){
                ErrorView.display(this.getClass().getName(),"Invalid Value. Try again. It has to be a number. Enter Q to exit.");
            }
        }  
        
        return selectionDouble;
    }
}
