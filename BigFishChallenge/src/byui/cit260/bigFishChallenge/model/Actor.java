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
    
    Billy("Billy", "It's hot today, deep water is cool!", 50),
    Cletus("Cletus", "My name is Cletus, have fun on the lake!", 30),
    BobbyRay("BobbyRay", "Get yourself some more bait at the Marina!", 15),
    Missy("Missy", "Weeds provide cover.", 26),
    Wade("Wade", "Get yourself some more fuel at the Marina!", 55),
    Phil("Phil", "Make sure to set that fish just right! Not too hard and not too soft!", 70),
    Jethro("Jethro", "Under the bridge is a nice shady spot!", 65),
    Lena("Lena", "Big ones like shade!", 19),
    Diego("Diego", "My name is Diego, hope you catch the Big One!", 26),
    Martha("Martha", "The big ones like to keep cool!", 41),
    NoActor("noActor", "There is no body here", 0);
    
    
    
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
