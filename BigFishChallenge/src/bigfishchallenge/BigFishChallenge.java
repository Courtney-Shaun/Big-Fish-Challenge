/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bigfishchallenge;

import byui.cit260.bigFishChallenge.model.Player;

/**
 *
 * @author shaunathan
 */
public class BigFishChallenge {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("George Jetson");
        playerOne.setBestTime(10);
        playerOne.setFewestMoves(16);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
    }
    
}
