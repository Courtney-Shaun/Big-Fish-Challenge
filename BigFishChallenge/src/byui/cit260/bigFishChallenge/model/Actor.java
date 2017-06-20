/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.model;

import java.io.Serializable;

/**
 *
 * @author cody
 */
public enum Actor implements Serializable{
    
    Billy("My name is Billy"),
    Cletus("My name is Cletus"),
    BobbyRay("My name is Bobby Ray"),
    Missy("My name is Missy"),
    Wade("My name is Wade"),
    Phil("My name is Phil"),
    Jethro("My name is Jethro"),
    Lena("My name is Lena"),
    Diego("My name is Diego"),
    Martha("My name is Martha");
    
    
    private final MainScene location;
    private final String clue;

    Actor(String clue) {
        this.clue = clue; 
        location = new MainScene(1);
    }
    
    public MainScene getLocation() {
        return location;
    }

    public String getClue() {
        return clue;
    }

    @Override
    public String toString() {
        return "Actor{" + "scene=" + location + ", clue=" + clue + '}';
    }
        
}
