/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import byui.cit260.bigFishChallenge.model.Obstacle;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Group
 */
public class HelpMenuView  extends View{
    
    public HelpMenuView() {
        super("\n"
              + "\n--------------------------------"
              + "\n Help Menu                     |"
              + "\n--------------------------------"
              + "\nO - Objective of the game"
              + "\nF - About Fuel"
              + "\nB - About Bait"
              + "\nC - Casting a Line"
              + "\nV - About Obstacles"
              + "\nI - Interpreting Clues"
              + "\nP - Print obstacles to a file"  
              + "\nQ - Quit"
              + "\n---------------------------------");
    }
    
    @Override
    public boolean doAction(String choice) {
        
        choice = choice.toUpperCase(); // convert choice to upper case
        
        switch (choice) {
            case "O": // View objective of the game
                this.viewObjective();
                break;
            case "F": // display help about fuel
                this.aboutFuel();
                break;
            case "B": // display help about bait
                this.aboutBait();
                break;
            case "C": // display help on casting a line
                this.aboutCastLine();
                break;
            case "V": //display the list of obstacles and their power
                this.viewObstacles();
                break;
            case "P": //print list of obstacles and thier power to a file
                this.printObstacles();
                break;
            case "I": // display help on interpret clues
                this.interpretClues();
                break;
            default:
               ErrorView.display(this.getClass().getName(),"\n*** Invalid selection *** Try again");
                break;
            
        }
       
        return false;
    }

    private void viewObjective() {
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n Objective of the Game         |"
              + "\n--------------------------------"
              + "\n The objective of Big Fish"
              + "\n Challenge is to catch 30lb of"
              + "\n fish before you run out of gas."
              + "\n When you succeed, you have"
              + "\n to make it back to the boat"
              + "\n launch (BL)."
              + "\n--------------------------------");
    }

    private void aboutFuel() {
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n About Fuel                    |"
              + "\n--------------------------------"
              + "\n You must always have fuel in"
              + "\n your tank to move around. As"
              + "\n you move, keep an eye on your"
              + "\n fuel level. If you run out of"
              + "\n fuel while you are on the"
              + "\n water, you lose the game. You"
              + "\n can buy more fuel at the"
              + "\n marina."
              + "\n--------------------------------");
    }

    private void aboutBait() {
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n About Bait                    |"
              + "\n--------------------------------"
              + "\n You can't fish without bait."
              + "\n As you fish, your bait"
              + "\n inventory will decrease. If you"
              + "\n run out, you will have to go"
              + "\n back to the marina to buy more."
              + "\n if you get your line caught"
              + "\n on obstacles, you lose some bait."
              + "\n--------------------------------");
    }

    private void aboutCastLine() {
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n About Casting                  |"
              + "\n--------------------------------"
              + "\n To catch fish, you must cast"
              + "\n your line into the water. When"
              + "\n you cast, you may feel a tug on"
              + "\n the line. You must then choose"
              + "\n how hard you must pull to set"
              + "\n the hook in the fish's mouth."
              + "\n Fish you catch are addeded to"
              + "\n your inventory."
              + "\n--------------------------------");
    }
    private void viewObstacles() {
        
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n About Obstacles               |"
              + "\n--------------------------------"
              + "\n Around the lake there are many"
              + "\n obstacals waiting to trip you"
              + "\n up.  At best you may have to"
              + "\n recast.  At worst you may have"
              + "\n a hook in your ear!  Here is a"
              + "\n list of the obstacales."
              + "\n Good luck anglers!"
              + "\n--------------------------------");
        
        int allObstacles = Obstacle.values().length;
        int total = 0;
        double average = 0;
        
        StringBuilder line;
                       
        this.console.println("\n      LIST OF OBSTACLES");
        line = new StringBuilder("                        ");
        line.insert(0, "OBSTACLE");
        //line.insert(19, "SEVERITY");
        
        this.console.println(line.toString());
            for(Obstacle currentObstacle : Obstacle.values() ) {
                total += currentObstacle.getPower();
            
                line = new StringBuilder("                              ");
                line.insert(0, currentObstacle.getObstacle());
                //line.insert(23, currentObstacle.getPower());
                this.console.println(line.toString());
            }
     average = total / allObstacles;
    
    //this.console.println("\n The average severity of the obstacles is " + average);

}
private void interpretClues() {
        this.console.println("\n"
              + "\n--------------------------------"
              + "\n About Clues                   |"
              + "\n--------------------------------"
              + "\n There are other people fishing"
              + "\n all over Greer's Ferry Lake."
              + "\n Their clues may help you."
              + "\n--------------------------------");
    }

    private void printObstacles() {
        
        String filePrompt = displayMessage;
        
        displayMessage = "\n\nEnter the file path for where the file is to be saved.  Only enter filename for default location.";
        String filePath = this.getInput();
        
        try(FileOutputStream fops = new FileOutputStream(filePath)) {
            PrintWriter display = new PrintWriter(fops, true);
        
            int allObstacles = Obstacle.values().length;
            int total = 0;
            double average = 0;
        
            StringBuilder line;
                       
            display.println("\n      LIST OF OBSTACLES");
            line = new StringBuilder("                        ");
            line.insert(0, "OBSTACLE");
            line.insert(19, "SEVERITY");
        
            display.println(line.toString());
                for(Obstacle currentObstacle : Obstacle.values() ) {
                    total += currentObstacle.getPower();
            
                line = new StringBuilder("                              ");
                line.insert(0, currentObstacle.getObstacle());
                line.insert(23, currentObstacle.getPower());
                display.println(line.toString());
            }
            average = total / allObstacles;
    
            display.println("\n The average severity of the obstacles is " + average);
            
            this.console.println("\nYou have saved successuflly to file: " + filePath);
    
    
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "\n Error saving file to path" + filePath + "," + e.getMessage());
        }
        
        displayMessage = filePrompt;
    } 

    
}