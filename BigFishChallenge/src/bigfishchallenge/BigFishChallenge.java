/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigfishchallenge;

import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.Player;
import byui.cit260.bigFishChallenge.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class BigFishChallenge {

    private static Game currentGame = null;
    private static Player player = null;
       
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    
    public static void main(String[] args) {
       try {
            playGame();
            } catch (Throwable te) {
                System.out.println(te.getMessage());
                te.printStackTrace();
                playGame();
        }         
        
    }
    
    public static void playGame() {
        try {
            //open character stream files for user i/o
            BigFishChallenge.inFile = new BufferedReader(new InputStreamReader(System.in));

            BigFishChallenge.outFile = new PrintWriter(System.out, true);

            //open log file
            String filePath = "log.txt";
            BigFishChallenge.logFile = new PrintWriter(filePath);
            
            StartProgramView startProgramView = new StartProgramView();

            try {
            startProgramView.display();
            } catch (Throwable te) {
                System.out.println(te.getMessage());
                te.printStackTrace();
                startProgramView.display();
            }
        } catch (Throwable e) {
            System.out.println("Exception: " + e.toString() +
                                "\nCause: " + e.getCause() +
                                "\nMessage: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (BigFishChallenge.inFile != null)
                    BigFishChallenge.inFile.close();
                
                if (BigFishChallenge.outFile != null)
                    BigFishChallenge.outFile.close();
                
                if (BigFishChallenge.logFile != null)
                    BigFishChallenge.logFile.close();
            } catch (IOException ex) {
                System.out.println("Error closing files.");
                return;
            }
            
        }
    }
    
    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        BigFishChallenge.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        BigFishChallenge.player = player;
    }
    
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        BigFishChallenge.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        BigFishChallenge.inFile = inFile;
    }
    
    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        BigFishChallenge.logFile = logFile;
    }
    
    
}
