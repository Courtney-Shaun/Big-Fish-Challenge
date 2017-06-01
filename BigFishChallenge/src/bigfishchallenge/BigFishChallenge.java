/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigfishchallenge;

import byui.cit260.bigFishChallenge.model.Actor;
import byui.cit260.bigFishChallenge.model.Fish;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.Location;
import byui.cit260.bigFishChallenge.model.Map;
import byui.cit260.bigFishChallenge.model.MarinaScene;
import byui.cit260.bigFishChallenge.model.Player;
import byui.cit260.bigFishChallenge.model.MainScene;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.view.StartProgramView;


public class BigFishChallenge {

    public static void main(String[] args) {
                
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.displayStartProgramView();
        
        
    }
    
    public static void teamClassTest() {
        Player playerOne = new Player();
        
        playerOne.setName("George Jetson");
        playerOne.setBestTime(10);
        playerOne.setFewestMoves(16);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
    }
            
    public static void kellyClassTest() {
        
        Fish tigerMusky = new Fish();
        
        tigerMusky.setType("Champion Fish");
        tigerMusky.setLength(49);
        tigerMusky.setWeight(33);
        
        String fishInfo = tigerMusky.toString();
        System.out.println(fishInfo);
        
        
        Game newGame = new Game();
        
        newGame.setTotalMoves(20);
        
        String gameInfo = newGame.toString();
        System.out.println(gameInfo);
        
        
        MarinaScene proShop = new MarinaScene();
        proShop.setBait(5);
        proShop.setFuel(30);
        proShop.setMoney(120);
        
        String marinaSceneInfo = proShop.toString();
        System.out.println(marinaSceneInfo);
        
    }
    
    public static void shaunClassTest() {
        
        Map boatDock = new Map();
        
        boatDock.setDescription("Welcome to the lake.  Let's get out on the water and have some fun!");
        boatDock.setRowCount(25);
        boatDock.setColumnCount(25);
        boatDock.setCurrentRow(1);
        boatDock.setCurrentColumn(1);
        boatDock.setCurrentScene("Boat Dock");
        
        
        String sceneInfo = boatDock.toString();
        System.out.println(sceneInfo);
        
        Location locationNow = new Location();
        
        locationNow.setRow(1);
        locationNow.setColumn(1);
        locationNow.setVisited("YES");
        
        String locationInfo = locationNow.toString();
        System.out.println(locationInfo);
    
    }
   
    public static void codyClassTest() {
        Actor shopClerk = new Actor();
        
        shopClerk.setName("Billy Ray");
        shopClerk.setScene("Marina");
        shopClerk.setClue("Rumor has it the fish are biting like crazy up in them trees over thar'!");
        
        String actorInfo = shopClerk.toString();
        System.out.println(actorInfo);
        
        
        MainScene fishingHole = new MainScene();
        
        fishingHole.setDescription("You are near the shore and the water is calm. Dead tree trunks and tall reeds at the shoreline make a great place for the fish to hide.");
        fishingHole.setName("White Sands Cove");
        fishingHole.setObstacle("Your trolling motor got caught in the weeds.");
        
        String fishingHoleInfo = fishingHole.toString();
        System.out.println(fishingHoleInfo);
        
        
        InventoryItem playerBait = new InventoryItem();
        
        playerBait.setItemType("bait");
        playerBait.setQuantityInStock(15);
        playerBait.setRequiredAmount(5);
        
        String playerBaitInfo = playerBait.toString();
        System.out.println(playerBaitInfo);
        
    }
    
}
