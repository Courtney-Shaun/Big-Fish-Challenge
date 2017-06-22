/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;
import java.util.Objects;

public class MainScene implements Serializable{
    
    private String description;
    private String name;
    private String obstacle;

    public MainScene() {
    }

    private void setMapSymbol(String _st_) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setBlocked(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMapSymbol() {
        System.out.println("\nGET MAP SYMBOLS");
        return "HI";
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
    
    private static MainScene[] createScenes() {
        MainScene[] scenes = new MainScene[SceneType.values().length];
        
        MainScene startScene = new MainScene();
        startScene.setDescription("this is the starting scene");
        startScene.setMapSymbol(" ST ");
        startScene.setBlocked(false);
        scenes[SceneType.start.ordinal()] = startScene;
        
        MainScene deepWaterScene = new MainScene();
        deepWaterScene.setDescription("this is the deepWater scene");
        deepWaterScene.setMapSymbol(" DW ");
        deepWaterScene.setBlocked(false);
        scenes[SceneType.deepWater.ordinal()] = deepWaterScene;
        
        MainScene shallowWaterScene = new MainScene();
        shallowWaterScene.setDescription("this is the shallowWater scene");
        shallowWaterScene.setMapSymbol(" SW ");
        shallowWaterScene.setBlocked(false);
        scenes[SceneType.shallowWater.ordinal()] = shallowWaterScene;
        
        MainScene rockyScene = new MainScene();
        rockyScene.setDescription("this is the rocky scene");
        rockyScene.setMapSymbol(" RK ");
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.description);
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.obstacle);
        return hash;
    }

    @Override
    public String toString() {
        return "MainScene{" + "description=" + description + ", name=" + name + ", obstacle=" + obstacle + '}';
    }
    
    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MainScene other = (MainScene) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.obstacle, other.obstacle)) {
            return false;
        }
        return true;
    }
    
    
}
