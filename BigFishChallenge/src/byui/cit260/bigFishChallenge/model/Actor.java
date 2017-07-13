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
    
    Billy("Billy", "It's hot today, the fish like the deep water where its cool!", 50),
    Cletus("Cletus", "Have fun on the lake!", 30),
    BobbyRay("Bobby Ray", "If you run out of bait, get some more bait at the Marina!", 15),
    Missy("Missy", "Them fishies like to hide in the weeds.", 26),
    Wade("Wade", "Don't run out of gas, you'll get stuck out here!", 55),
    Phil("Phil", "Make sure to set that fish hook just right! Not too hard and not too soft!", 70),
    Jethro("Jethro", "Under the bridge is a nice shady spot!", 65),
    Lena("Lena", "Big ones like the deep water!", 19),
    Diego("Diego", "Fish aren't biting for me today. Hope you have better luck!", 26),
    Martha("Martha", "The big ones like to keep cool!", 41),
    NoActor("noActor", "There is nobody here", 0);
    
    
    
    private final String clue;
    private final String name;
    private final int age;

    Actor(String name, String clue, int age) {
        this.clue = clue; 
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }
    
   

    public String getClue() {
        return clue;
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Actor{" + "name=" + name + ", clue=" + clue + '}';
    }
        
}
