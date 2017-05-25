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
    }
    
}
