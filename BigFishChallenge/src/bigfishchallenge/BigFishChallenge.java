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
import java.util.logging.Level;
import java.util.logging.Logger;


public class BigFishChallenge {

    private static Game currentGame = null;
    private static Player player = null;
       
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;

    private static PrintWriter logFile = null;

    
    public static void main(String[] args) {
                
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
    
    
    
    ////////////////////////////////////////////////////////////////
    
//    public static void teamClassTest() {
//        Player playerOne = new Player();
//        
//        playerOne.setName("George Jetson");
//        playerOne.setBestTime(10);
//        playerOne.setFewestMoves(16);
//        
//        String playerInfo = playerOne.toString();
//        System.out.println(playerInfo);
//    }
//            
//    public static void kellyClassTest() {
//        
//        Fish tigerMusky = new Fish();
//        
//        tigerMusky.setType("Champion Fish");
//        tigerMusky.setLength(49);
//        tigerMusky.setWeight(33);
//        
//        String fishInfo = tigerMusky.toString();
//        System.out.println(fishInfo);
//        
//        
//        Game newGame = new Game();
//        
//        newGame.setTotalMoves(20);
//        
//        String gameInfo = newGame.toString();
//        System.out.println(gameInfo);
//        
//        
//        MarinaScene proShop = new MarinaScene();
//        proShop.setBait(5);
//        proShop.setFuel(30);
//        proShop.setMoney(120);
//        
//        String marinaSceneInfo = proShop.toString();
//        System.out.println(marinaSceneInfo);
//        
//    }
//    
//    public static void shaunClassTest() {
//        
//        Map boatDock = new Map();
//        
//        boatDock.setDescription("Welcome to the lake.  Let's get out on the water and have some fun!");
//        boatDock.setRowCount(25);
//        boatDock.setColumnCount(25);
//        boatDock.setCurrentRow(1);
//        boatDock.setCurrentColumn(1);
//        boatDock.setCurrentScene("Boat Dock");
//        
//        
//        String sceneInfo = boatDock.toString();
//        System.out.println(sceneInfo);
//        
//        Location locationNow = new Location();
//        
//        locationNow.setRow(1);
//        locationNow.setColumn(1);
//        locationNow.setVisited("YES");
//        
//        String locationInfo = locationNow.toString();
//        System.out.println(locationInfo);
//    
//    }
   
//    public static void codyClassTest() {
//        Actor shopClerk = new Actor();
//        
//        shopClerk.setName("Billy Ray");
//        shopClerk.setScene("Marina");
//        shopClerk.setClue("Rumor has it the fish are biting like crazy up in them trees over thar'!");
//        
//        String actorInfo = shopClerk.toString();
//        System.out.println(actorInfo);
//        
//        
//        MainScene fishingHole = new MainScene();
//        
//        fishingHole.setDescription("You are near the shore and the water is calm. Dead tree trunks and tall reeds at the shoreline make a great place for the fish to hide.");
//        fishingHole.setName("White Sands Cove");
//        fishingHole.setObstacle("Your trolling motor got caught in the weeds.");
//        
//        String fishingHoleInfo = fishingHole.toString();
//        System.out.println(fishingHoleInfo);
//        
//        
//        InventoryItem playerBait = new InventoryItem();
//        
//        playerBait.setItemType("bait");
//        playerBait.setQuantityInStock(15);
//        playerBait.setRequiredAmount(5);
//        
//        String playerBaitInfo = playerBait.toString();
//        System.out.println(playerBaitInfo);
//        
//    }

    private class console {

        private void println(String message) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public console() {
        }
    }
    
}
