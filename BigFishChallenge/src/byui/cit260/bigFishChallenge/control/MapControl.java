/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import byui.cit260.bigFishChallenge.model.Actor;
import byui.cit260.bigFishChallenge.model.MainScene;
import byui.cit260.bigFishChallenge.model.Map;
import byui.cit260.bigFishChallenge.model.Obstacle;
import java.util.Random;

/**
 *
 * @author shaunathan
 */
public class MapControl {

    static Map createMap() {
        Map map = new Map(5, 5);
        
        MainScene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        movePlayerToStartingLocation(map);
        return map;
    }

    public static void movePlayerToStartingLocation(Map map) {
        // If starting location is not supposed to be 0,0 then use the correct values here.
        movePlayer(map, 4, 1); // or instead of 0,0 you can select a different starting location
    }

    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);

    }
    
    public enum SceneType {
        boatLaunch,
        deepWater1,
        deepWater2,
        deepWater3,
        deepWater4,
        deepWater5,
        shallowWater1,
        shallowWater2,
        shallowWater3,
        shallowWater4,
        shallowWater5,
        shallowWater6,
        shallowWater7,
        rocky1,
        rocky2,
        weeds1,
        weeds2,
        weeds3,
        weeds4,
        roughWater1,
        roughWater2,
        roughWater3,
        roughWater4,
        underBridge,
        marina;
    }
    
    /**
     *
     * @return
     */
    public static int weightRandomizer() {
        
        Random rn = new Random();
        int randomWeight = rn.nextInt(21);
        return randomWeight;
    }
    
    public static int obstacleRandomizer() {
        
        Random rn = new Random();
        int randomObstacle = rn.nextInt(2);
        return randomObstacle;
    }
    
    public static MainScene[] createScenes() {
        MainScene[] scenes = new MainScene[SceneType.values().length];
        
        MainScene boatLaunch = new MainScene();
        boatLaunch.setDescription("--------------------------------"
                  + "\n You've just pulled your boat"
                  + "\n into Greers Ferry Lake. Its a"
                  + "\n beautiful sunny morning and"
                  + "\n you're excited to get started."
                  + "\n Be sure to pick up some bait"
                  + "\n and fuel at the Marina (MR)"
                  + "\n before heading out!");
        boatLaunch.setMapSymbol(" BL ");
        boatLaunch.setName("at the boat launch."); //"You are currently" + INSERT THIS STRING
        boatLaunch.setFishWeight(-1);
        boatLaunch.setBlocked(false);
        boatLaunch.setActor(Actor.Cletus);
        scenes[SceneType.boatLaunch.ordinal()] = boatLaunch;
        
        MainScene deepWater1 = new MainScene();
        deepWater1.setDescription("--------------------------------"
                  + "\n You're pretty far out"
                  + "\n now. It's calm and about"
                  + "\n 22 feet deep.");
        deepWater1.setMapSymbol(" DW ");
        deepWater1.setName("in deep water."); //"You are currently" + INSERT THIS STRING
        deepWater1.setFishWeight(weightRandomizer());
        deepWater1.setBlocked(false);
        deepWater1.setActor(Actor.Billy);
        if (obstacleRandomizer() != 0) {
            deepWater1.setObstacle(Obstacle.line);
        }
        scenes[SceneType.deepWater1.ordinal()] = deepWater1;
        
        MainScene deepWater2 = new MainScene();
        deepWater2.setDescription("--------------------------------"
                  + "\n You're quite a ways from"
                  + "\n shore. It's calm and about"
                  + "\n 14 feet deep.");
        deepWater2.setMapSymbol(" DW ");
        deepWater2.setName("in deep water."); //"You are currently" + INSERT THIS STRING
        deepWater2.setFishWeight(weightRandomizer());
        deepWater2.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            deepWater2.setObstacle(Obstacle.algae);
        }
        scenes[SceneType.deepWater2.ordinal()] = deepWater2;
        
        MainScene deepWater3 = new MainScene();
        deepWater3.setDescription("--------------------------------"
                  + "\n You're out pretty far."
                  + "\n It's quiet. The water is"
                  + "\n about 20 feet deep.");
        deepWater3.setMapSymbol(" DW ");
        deepWater3.setName("in deep water."); //"You are currently" + INSERT THIS STRING
        deepWater3.setFishWeight(weightRandomizer());
        deepWater3.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            deepWater3.setObstacle(Obstacle.player);
        }
        deepWater3.setActor(Actor.Lena);
        scenes[SceneType.deepWater3.ordinal()] = deepWater3;
        
        MainScene deepWater4 = new MainScene();
        deepWater4.setDescription("--------------------------------"
                  + "\n You're pretty far out"
                  + "\n now. It's calm and about"
                  + "\n 22 feet deep.");
        deepWater4.setMapSymbol(" DW ");
        deepWater4.setName("in deep water."); //"You are currently" + INSERT THIS STRING
        deepWater4.setFishWeight(weightRandomizer());
        deepWater4.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            deepWater4.setObstacle(Obstacle.boat);
        }
        scenes[SceneType.deepWater4.ordinal()] = deepWater4;
        
        MainScene deepWater5 = new MainScene();
        deepWater5.setDescription("--------------------------------"
                  + "\n You aren't too far from"
                  + "\n shore, but the water"
                  + "\n is pretty deep already.");
        deepWater5.setMapSymbol(" DW ");
        deepWater5.setName("in deep water."); //"You are currently" + INSERT THIS STRING
        deepWater5.setFishWeight(weightRandomizer());
        deepWater5.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            deepWater5.setObstacle(Obstacle.line);
        }
        deepWater5.setActor(Actor.BobbyRay);
        scenes[SceneType.deepWater5.ordinal()] = deepWater5;        
        
        MainScene shallowWater1 = new MainScene();
        shallowWater1.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 5 feet"
                  + "\n deep.");
        shallowWater1.setMapSymbol(" SW ");
        shallowWater1.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater1.setFishWeight(weightRandomizer());
        shallowWater1.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater1.setObstacle(Obstacle.player);
        }
        scenes[SceneType.shallowWater1.ordinal()] = shallowWater1;
        
        MainScene shallowWater2 = new MainScene();
        shallowWater2.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 7 feet"
                  + "\n deep.");
        shallowWater2.setMapSymbol(" SW ");
        shallowWater2.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater2.setFishWeight(weightRandomizer());
        shallowWater2.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater2.setObstacle(Obstacle.algae);
        }
        shallowWater2.setActor(Actor.Martha);
        scenes[SceneType.shallowWater2.ordinal()] = shallowWater2;
        
        MainScene shallowWater3 = new MainScene();
        shallowWater3.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 4 feet"
                  + "\n deep.");
        shallowWater3.setMapSymbol(" SW ");
        shallowWater3.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater3.setFishWeight(weightRandomizer());
        shallowWater3.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater3.setObstacle(Obstacle.line);
        }
        scenes[SceneType.shallowWater3.ordinal()] = shallowWater3;
        
        MainScene shallowWater4 = new MainScene();
        shallowWater4.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 6 feet"
                  + "\n deep.");
        shallowWater4.setMapSymbol(" SW ");
        shallowWater4.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater4.setFishWeight(weightRandomizer());
        shallowWater4.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater4.setObstacle(Obstacle.tree);
        }
        scenes[SceneType.shallowWater4.ordinal()] = shallowWater4;
        
        MainScene shallowWater5 = new MainScene();
        shallowWater5.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 8 feet"
                  + "\n deep.");
        shallowWater5.setMapSymbol(" SW ");
        shallowWater5.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater5.setFishWeight(weightRandomizer());
        shallowWater5.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater5.setObstacle(Obstacle.player);
        }
        scenes[SceneType.shallowWater5.ordinal()] = shallowWater5;
        
        MainScene shallowWater6 = new MainScene();
        shallowWater6.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 4 feet"
                  + "\n deep.");
        shallowWater6.setMapSymbol(" SW ");
        shallowWater6.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater6.setFishWeight(weightRandomizer());
        shallowWater6.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater6.setObstacle(Obstacle.algae);
        }
        scenes[SceneType.shallowWater6.ordinal()] = shallowWater6;
        
        MainScene shallowWater7 = new MainScene();
        shallowWater7.setDescription("--------------------------------"
                  + "\n It's calm here, and"
                  + "\n probably about 5 feet"
                  + "\n deep.");
        shallowWater7.setMapSymbol(" SW ");
        shallowWater7.setName("in shallow water."); //"You are currently" + INSERT THIS STRING
        shallowWater7.setFishWeight(weightRandomizer());
        shallowWater7.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            shallowWater7.setObstacle(Obstacle.branches);
        }
        scenes[SceneType.shallowWater7.ordinal()] = shallowWater7;
        
        MainScene rocky1 = new MainScene();
        rocky1.setDescription("--------------------------------"
                  + "\n Don't bump into the"
                  + "\n rocks! It can hurt your"
                  + "\n boat AND scare away them"
                  + "\n fish!");
        rocky1.setMapSymbol(" RK ");
        rocky1.setName("in rocky water."); //"You are currently" + INSERT THIS STRING
        rocky1.setFishWeight(weightRandomizer());
        rocky1.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            rocky1.setObstacle(Obstacle.rocks);
        }
        rocky1.setActor(Actor.Diego);
        scenes[SceneType.rocky1.ordinal()] = rocky1;
        
        MainScene rocky2 = new MainScene();
        rocky2.setDescription("--------------------------------"
                  + "\n Don't bump into the"
                  + "\n rocks! It can hurt your"
                  + "\n boat AND scare away them"
                  + "\n fish!");
        rocky2.setMapSymbol(" RK ");
        rocky2.setName("in rocky water."); //"You are currently" + INSERT THIS STRING
        rocky2.setFishWeight(weightRandomizer());
        rocky2.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            rocky2.setObstacle(Obstacle.rocks);
        }
        scenes[SceneType.rocky2.ordinal()] = rocky2;
        
        MainScene weeds1 = new MainScene();
        weeds1.setDescription("--------------------------------"
                  + "\n Your boat is near the"
                  + "\n shore. It's shallow and"
                  + "\n there are lots of weeds."
                  + "\n Try not to get your prop"
                  + "stuck!");
        weeds1.setMapSymbol(" WD ");
        weeds1.setName("in the weeds."); //"You are currently" + INSERT THIS STRING
        weeds1.setFishWeight(weightRandomizer());
        weeds1.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            weeds1.setObstacle(Obstacle.line);
        }
        weeds1.setActor(Actor.Missy);
        scenes[SceneType.weeds1.ordinal()] = weeds1;
        
        MainScene weeds2 = new MainScene();
        weeds2.setDescription("--------------------------------"
                  + "\n Your boat is near the"
                  + "\n shore. It's shallow and"
                  + "\n there are lots of weeds."
                  + "\n Try not to get your prop"
                  + "stuck!");
        weeds2.setMapSymbol(" WD ");
        weeds2.setName("in the weeds."); //"You are currently" + INSERT THIS STRING
        weeds2.setFishWeight(weightRandomizer());
        weeds2.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            weeds2.setObstacle(Obstacle.weeds);
        }
        scenes[SceneType.weeds2.ordinal()] = weeds2;
        
        MainScene weeds3 = new MainScene();
        weeds3.setDescription("--------------------------------"
                  + "\n Your boat is near the"
                  + "\n shore. It's shallow and"
                  + "\n there are lots of weeds."
                  + "\n Try not to get your prop"
                  + "stuck!");
        weeds3.setMapSymbol(" WD ");
        weeds3.setName("in the weeds."); //"You are currently" + INSERT THIS STRING
        weeds3.setFishWeight(weightRandomizer());
        weeds3.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            weeds3.setObstacle(Obstacle.branches);
        }
        scenes[SceneType.weeds3.ordinal()] = weeds3;
        
        MainScene weeds4 = new MainScene();
        weeds4.setDescription("--------------------------------"
                  + "\n Your boat is near the"
                  + "\n shore. It's shallow and"
                  + "\n there are lots of weeds."
                  + "\n Try not to get your prop"
                  + "stuck!");
        weeds4.setMapSymbol(" WD ");
        weeds4.setName("in the weeds."); //"You are currently" + INSERT THIS STRING
        weeds4.setFishWeight(weightRandomizer());
        weeds4.setBlocked(false);
        weeds4.setActor(Actor.Diego);
        if (obstacleRandomizer() != 0) {
            weeds4.setObstacle(Obstacle.algae);
        }
        scenes[SceneType.weeds4.ordinal()] = weeds4;
        
        MainScene roughWater1 = new MainScene();
        roughWater1.setDescription("--------------------------------"
                  + "\n It's pretty deep here"
                  + "\n and your boat is rocking"
                  + "\n quite a bit from the waves.");
        roughWater1.setMapSymbol(" RW ");
        roughWater1.setName("in rough water."); //"You are currently" + INSERT THIS STRING
        roughWater1.setFishWeight(weightRandomizer());
        roughWater1.setBlocked(false);
        if (obstacleRandomizer() != 0)
            roughWater1.setObstacle(Obstacle.player);
        scenes[SceneType.roughWater1.ordinal()] = roughWater1;
        
        MainScene roughWater2 = new MainScene();
        roughWater2.setDescription("--------------------------------"
                  + "\n It's pretty deep here"
                  + "\n and your boat is rocking"
                  + "\n quite a bit from the waves.");
        roughWater2.setMapSymbol(" RW ");
        roughWater2.setName("in rough water."); //"You are currently" + INSERT THIS STRING
        roughWater2.setFishWeight(weightRandomizer());
        roughWater2.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            roughWater2.setObstacle(Obstacle.boat);
        }
        roughWater2.setActor(Actor.Wade);
        scenes[SceneType.roughWater2.ordinal()] = roughWater2;
        
        MainScene roughWater3 = new MainScene();
        roughWater3.setDescription("--------------------------------"
                  + "\n It's pretty deep here"
                  + "\n and your boat is rocking"
                  + "\n quite a bit from the waves.");
        roughWater3.setMapSymbol(" RW ");
        roughWater3.setName("in rough water."); //"You are currently" + INSERT THIS STRING
        roughWater3.setFishWeight(weightRandomizer());
        roughWater3.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            roughWater3.setObstacle(Obstacle.player);
        }
        scenes[SceneType.roughWater3.ordinal()] = roughWater3;
        
        MainScene roughWater4 = new MainScene();
        roughWater4.setDescription("--------------------------------"
                  + "\n It's pretty deep here"
                  + "\n and your boat is rocking"
                  + "\n quite a bit from the waves.");
        roughWater4.setMapSymbol(" RW ");
        roughWater4.setName("in rough water."); //"You are currently" + INSERT THIS STRING
        roughWater4.setFishWeight(weightRandomizer());
        roughWater4.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            roughWater4.setObstacle(Obstacle.boat);
        }
        roughWater4.setActor(Actor.Phil);
        scenes[SceneType.roughWater4.ordinal()] = roughWater4;
        
        MainScene underBridge = new MainScene();
        underBridge.setDescription("--------------------------------"
                  + "\n This is where the Bear"
                  + "\n Branch River flows into"
                  + "\n the lake. There's a fairly"
                  + "\n strong current here.");
        underBridge.setMapSymbol(" UB ");
        underBridge.setName("under the bridge."); //"You are currently" + INSERT THIS STRING
        underBridge.setFishWeight(weightRandomizer());
        underBridge.setBlocked(false);
        if (obstacleRandomizer() != 0) {
            underBridge.setObstacle(Obstacle.tree);
        }
        underBridge.setActor(Actor.Jethro);
        scenes[SceneType.underBridge.ordinal()] = underBridge;
        
        MainScene marina = new MainScene();
        marina.setDescription("--------------------------------"
                  + "\n You can buy fuel and bait"
                  + "\n here. Make sure you can"
                  + "\n carry it all back to your"
                  + "\n boat!");
        marina.setMapSymbol(" MR ");
        marina.setName("at the marina."); //"You are currently" + INSERT THIS STRING
        marina.setFishWeight(-1);
        marina.setBlocked(false);
        scenes[SceneType.marina.ordinal()] = marina;
        
        return scenes;
    }
    
}
