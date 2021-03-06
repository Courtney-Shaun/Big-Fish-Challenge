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
    private Obstacle obstacle;
    private String mapSymbol;
    private int fishWeight;
    private Actor actor;

    public int getFishWeight() {
        return this.fishWeight;
    }

    public void setFishWeight(int fishWeight) {
        this.fishWeight = fishWeight;
    }
    

    public MainScene() {
        //actor = Actor.NoActor;
    }

    public void setMapSymbol(String symbol) {
        this.mapSymbol = symbol;
    }

    public void setBlocked(boolean blocked) {
        blocked = false;
    }

    public String getMapSymbol() {
        return this.mapSymbol;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
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

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
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
