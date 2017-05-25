/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author shaunathan
 */
public class PlayerControlTest {
    
    public PlayerControlTest() {
    }

    /**
     * Test of checkWeight method, of class PlayerControl.
     */
    @Test
    public void testCheckWeight() {
        System.out.println("checkWeight Case 1");
        int inventoryWeight = 50;
        int newWeight = 10;
        PlayerControl instance = new PlayerControl();
        int expResult = 40;
        int result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        
        System.out.println("checkWeight Case 2");
        inventoryWeight = -1;
        newWeight = 10;
        expResult = -1;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("checkWeight Case 3");
        inventoryWeight = 50;
        newWeight = -1;
        expResult = -1;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("checkWeight Case 4");
        inventoryWeight = 50;
        newWeight = 51;
        expResult = -1;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("checkWeight Case 5");
        inventoryWeight = 100;
        newWeight = 0;
        expResult = 0;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("checkWeight Case 6");
        inventoryWeight = 0;
        newWeight = 100;
        expResult = 0;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("checkWeight Case 7");
        inventoryWeight = 50;
        newWeight = 50;
        expResult = 0;
        result = instance.checkWeight(inventoryWeight, newWeight);
        assertEquals(expResult, result, 0.01);
        
        
    }

    /**
     * Test of cast method, of class PlayerControl.
     */
    @Test
    public void testCast() {
        System.out.println("cast Case 1");
        int strength = 7;
        int fishWeight = 14;
        PlayerControl instance = new PlayerControl();
        int expResult = 0;
        int result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 2");
        strength = 0;
        fishWeight = 18;
        expResult = -1;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 3");
        strength = 5;
        fishWeight = 0;
        expResult = -1;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 4");
        strength = 8;
        fishWeight = 21;
        expResult = -1;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 5");
        strength = 10;
        fishWeight = 1;
        expResult = 19;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 6");
        strength = 1;
        fishWeight = 20;
        expResult = 18;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        System.out.println("cast Case 7");
        strength = 10;
        fishWeight = 20;
        expResult = 0;
        result = instance.cast(strength, fishWeight);
        assertEquals(expResult, result, 0.01);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
