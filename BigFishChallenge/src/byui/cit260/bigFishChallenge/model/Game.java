/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Kelly
 */
public class Game implements Serializable{
    // class instance variables
    private double totalMoves;
    
    private Map map;
    private Player player;
    private InventoryItem[] inventory;
    private ArrayList<Integer> totalFish = new ArrayList<>();
    
    public ArrayList<Integer> getTotalFish() {
        return totalFish;
    }
    
    public void setTotalFish(int weight) {
        
        this.totalFish.add(weight);
    }
    
    public InventoryItem[] getInventory() {
        return inventory;
    }

    public void setInventory(InventoryItem[] inventory) {
        this.inventory = inventory;
    }
    
    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game() {
    }
    
    

    public double getTotalMoves() {
        return totalMoves;
    }

    public void setTotalMoves(double totalMoves) {
        this.totalMoves = totalMoves;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.totalMoves) ^ (Double.doubleToLongBits(this.totalMoves) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "Game{" + "totalMoves=" + totalMoves + '}';
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
        final Game other = (Game) obj;
        if (Double.doubleToLongBits(this.totalMoves) != Double.doubleToLongBits(other.totalMoves)) {
            return false;
        }
        return true;
    }
    
    
}
