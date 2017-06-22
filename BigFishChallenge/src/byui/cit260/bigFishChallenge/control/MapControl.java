/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import byui.cit260.bigFishChallenge.model.MainScene;
import byui.cit260.bigFishChallenge.model.Map;

/**
 *
 * @author shaunathan
 */
public class MapControl {

    public static Map createMap() {
        Map map = new Map(5, 5);
        
        MainScene[] scenes = createScenes();
        
        GameControl.assignScenesToLocations(map, scenes);
        
        return map;
    }

    private static MainScene[] createScenes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
