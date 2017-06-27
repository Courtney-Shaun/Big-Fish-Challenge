/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.exceptions;

/**
 *
 * @author Cody
 */
public class PlayerControlException extends Exception {

    public PlayerControlException() {
    }

    public PlayerControlException(String string) {
        super(string);
    }

    public PlayerControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public PlayerControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public PlayerControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
}
