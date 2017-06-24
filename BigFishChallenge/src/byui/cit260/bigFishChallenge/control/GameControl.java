/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import bigfishchallenge.BigFishChallenge;
import byui.cit260.bigFishChallenge.model.Game;
import byui.cit260.bigFishChallenge.model.InventoryItem;
import byui.cit260.bigFishChallenge.model.Location;
import byui.cit260.bigFishChallenge.model.MainScene;
import byui.cit260.bigFishChallenge.control.MapControl.SceneType;
import byui.cit260.bigFishChallenge.model.Map;
import byui.cit260.bigFishChallenge.model.Player;
import java.util.ArrayList;

/**
 *
 * @author shaunathan
 */
public class GameControl {
    
    
    
    public static Player createPlayer(String name) {
        if (name == null) {
            return null;
        }
        
        Player player = new Player();
        player.setName(name);
        
        BigFishChallenge.setPlayer(player); // save the player
        
        return player;
    }
    
    public static void createNewGame(Player player) {
                
        Game game = new Game(); // create new game
        BigFishChallenge.setCurrentGame(game);  // save in BigFishChallenge
        
        game.setPlayer(player);  // save player in game
        
        // create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventory(inventoryList);
        
        
        Map map = MapControl.createMap(); //create and initialize new map
        game.setMap(map); //same map in 
        
        
        
    }

    static void assignScenesToLocations(Map map, MainScene[] scenes) {
        Location[][] locations = map.getLocations();
        
        locations[0][0].setScene(scenes[SceneType.rocky1.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.weeds1.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.shallowWater1.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.roughWater1.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.underBridge.ordinal()]);
        locations[1][0].setScene(scenes[SceneType.rocky2.ordinal()]);
        locations[1][1].setScene(scenes[SceneType.shallowWater2.ordinal()]);
        locations[1][2].setScene(scenes[SceneType.deepWater1.ordinal()]);
        locations[1][3].setScene(scenes[SceneType.deepWater2.ordinal()]);
        locations[1][4].setScene(scenes[SceneType.roughWater2.ordinal()]);
        locations[2][0].setScene(scenes[SceneType.shallowWater3.ordinal()]);
        locations[2][1].setScene(scenes[SceneType.roughWater3.ordinal()]);
        locations[2][2].setScene(scenes[SceneType.roughWater4.ordinal()]);
        locations[2][3].setScene(scenes[SceneType.deepWater3.ordinal()]);
        locations[2][4].setScene(scenes[SceneType.shallowWater4.ordinal()]);
        locations[3][0].setScene(scenes[SceneType.shallowWater5.ordinal()]);
        locations[3][1].setScene(scenes[SceneType.deepWater4.ordinal()]);
        locations[3][2].setScene(scenes[SceneType.shallowWater6.ordinal()]);
        locations[3][3].setScene(scenes[SceneType.deepWater5.ordinal()]);
        locations[3][4].setScene(scenes[SceneType.weeds2.ordinal()]);
        locations[4][0].setScene(scenes[SceneType.shallowWater7.ordinal()]);
        locations[4][1].setScene(scenes[SceneType.marina.ordinal()]);
        locations[4][2].setScene(scenes[SceneType.boatLaunch.ordinal()]);
        locations[4][3].setScene(scenes[SceneType.weeds3.ordinal()]);
        locations[4][4].setScene(scenes[SceneType.weeds4.ordinal()]);
        
        
    }

    public GameControl() {
        
    }
    
    public enum Item {
        fuel,
        bait,
        money,
        fish;
    }

    private static InventoryItem[] createInventoryList() {
               
        InventoryItem[] inventory = new InventoryItem[4];
        
        InventoryItem fuel = new InventoryItem();
        fuel.setItemType("Fuel");
        fuel.setQuantityInStock(0);
        fuel.setRequiredAmount(0);
        inventory[Item.fuel.ordinal()] = fuel;
        
        InventoryItem bait = new InventoryItem();
        bait.setItemType("Bait");
        bait.setQuantityInStock(0);
        bait.setRequiredAmount(0);
        inventory[Item.bait.ordinal()] = bait;
        
        InventoryItem money = new InventoryItem();
        money.setItemType("Money");
        money.setQuantityInStock(0);
        money.setRequiredAmount(0);
        inventory[Item.money.ordinal()] = money;
        
        InventoryItem fish = new InventoryItem();
        fish.setItemType("Fish");
        fish.setQuantityInStock(0);
        fish.setRequiredAmount(0);
        inventory[Item.fish.ordinal()] = fish;
        
        return inventory;
    }
    
    public static void addFish(int weight) {
        Game game = BigFishChallenge.getCurrentGame();
        
        
        game.setTotalFish(weight);
    }
    
    public static int checkFish() {
        Game game = BigFishChallenge.getCurrentGame();
        
        ArrayList<Integer> totalWeight = game.getTotalFish();
                
        int total = 0;
        for (int weight: totalWeight) {
            total += weight;
        }
        
        return total;
    }
    
}