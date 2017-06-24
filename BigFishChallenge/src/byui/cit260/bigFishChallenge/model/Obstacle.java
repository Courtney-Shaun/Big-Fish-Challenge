/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;

/**
 *
 * @author shaunathan
 */
public enum Obstacle implements Serializable {
    
    rocks("rocks", "Your line got caught in the rocks.", 7),
    branches("branches", "You managed to snag a branch. Better luck next time1", 5),
    line("line", "Your line got tangled with Billy Bob's.  Be more careful when you cast!", 3),
    weeds("weed", "Those weeds are pesky. Cast again!", 1),
    tree("tree", "Watch for those tree branches when you're under the bridge.", 6),
    boat("boat", "Your line got caught on the bottom of the boat, recast and try again!", 2),
    player("player", "You just snagged your ear!  Good luck getting that out!", 8),
    algae("algae", "Just when you thought you caught the big one!  It turns out its just algae!  Recast!", 0);
   
    
    private final String obstacle;
    private final String description;
    private final int power;
    
    
    Obstacle(String obstacle, String description, int power) {
        this.obstacle = obstacle;
        this.description = description;
        this.power = power;
    }
    
    public String getObstacle() {
        return obstacle;
    }
    
    public String getDescription() {
        return description;
    }

    public int getPower() {
        return power;
    }
    
    @Override
    public String toString() {
        return "Obstacle{" + "obstacle=" + obstacle + ", power" + power + '}'; 
       
    }
    
}