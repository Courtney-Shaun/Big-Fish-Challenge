/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import byui.cit260.bigFishChallenge.model.MainScene;
//import byui.cit260.bigFishChallenge.model.MainScene.SceneType;
import byui.cit260.bigFishChallenge.model.Map;

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
        movePlayer(map, 0, 0); // or instead of 0,0 you can select a different starting location
    }

    public static void movePlayer(Map map, int row, int column) {
        map.setCurrentLocation(map.getLocations()[row][column]);
        map.getCurrentLocation().setVisited(true);
        map.setCurrentRow(row);
        map.setCurrentColumn(column);

    }
    
    public enum SceneType {
        start,
        deepWater,
        shallowWater,
        rocky,
        weeds,
        roughWater,
        underBridge,
        marina,
        finish;
    }
    
    public static MainScene[] createScenes() {
        MainScene[] scenes = new MainScene[SceneType.values().length];
        
        MainScene startScene = new MainScene();
        startScene.setDescription("this is the starting scene");
        startScene.setMapSymbol(" ST ");
        startScene.setName("Start Scene");
        startScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startScene;
        
        MainScene deepWaterScene = new MainScene();
        deepWaterScene.setDescription("this is the deepWater scene");
        deepWaterScene.setMapSymbol(" DW ");
        deepWaterScene.setName("Deep Water Scene");
        deepWaterScene.setBlocked(false);
        scenes[SceneType.deepWater.ordinal()] = deepWaterScene;
        
        MainScene shallowWaterScene = new MainScene();
        shallowWaterScene.setDescription("this is the shallowWater scene");
        shallowWaterScene.setMapSymbol(" SW ");
        shallowWaterScene.setName("Shallow Water Scene");
        shallowWaterScene.setBlocked(false);
        scenes[SceneType.shallowWater.ordinal()] = shallowWaterScene;
        
        MainScene rockyScene = new MainScene();
        rockyScene.setDescription("this is the rocky scene");
        rockyScene.setMapSymbol(" RK ");
        rockyScene.setName("Rocky Scene");
        rockyScene.setBlocked(false);
        scenes[SceneType.rocky.ordinal()] = rockyScene;
        
        MainScene weedsScene = new MainScene();
        weedsScene.setDescription("this is the weeds scene");
        weedsScene.setMapSymbol(" WD ");
        weedsScene.setBlocked(false);
        scenes[SceneType.weeds.ordinal()] = weedsScene;
        
        MainScene roughWaterScene = new MainScene();
        roughWaterScene.setDescription("this is the roughWater scene");
        roughWaterScene.setMapSymbol(" RW ");
        roughWaterScene.setBlocked(false);
        scenes[SceneType.roughWater.ordinal()] = roughWaterScene;
        
        MainScene underBridgeScene = new MainScene();
        underBridgeScene.setDescription("this is the underBridge scene");
        underBridgeScene.setMapSymbol(" UB ");
        underBridgeScene.setBlocked(false);
        scenes[SceneType.underBridge.ordinal()] = underBridgeScene;
        
        MainScene marinaScene = new MainScene();
        marinaScene.setDescription("this is the marina scene");
        marinaScene.setMapSymbol(" MR ");
        marinaScene.setBlocked(false);
        scenes[SceneType.marina.ordinal()] = marinaScene;
        
        MainScene finishScene = new MainScene();
        finishScene.setDescription("this is the finish scene");
        finishScene.setMapSymbol(" FN ");
        finishScene.setBlocked(false);
        scenes[SceneType.finish.ordinal()] = finishScene;
        
        return scenes;
    }
    
}
