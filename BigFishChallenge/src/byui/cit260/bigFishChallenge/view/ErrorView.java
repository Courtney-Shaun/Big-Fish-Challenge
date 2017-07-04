/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import bigfishchallenge.BigFishChallenge;
import java.io.PrintWriter;

/**
 *
 * @author Cody
 */
public class ErrorView {
    
    private static final PrintWriter errorFile = BigFishChallenge.getOutFile();
    private static final PrintWriter logFile = BigFishChallenge.getLogFile();
    
    public static void display(String className, String errorMessage) {
        errorFile.println(
                    "--------------------------------------------------"
                  + "\n- ERROR -" + errorMessage
                  + "\n--------------------------------------------------");
        
        //log error
        logFile.println(className + " - " + errorMessage);
    }
    
}
