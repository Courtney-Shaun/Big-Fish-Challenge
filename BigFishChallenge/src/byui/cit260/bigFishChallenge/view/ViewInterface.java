/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

/**
 *
 * @author group
 */
public interface ViewInterface {
    
    public void display();
    public String getInput();
    public boolean doAction(String value);
    public int getIntInput(String question, int maxVal, int minVal);
    public double getDoubleInput(String question, double maxVal, double minVal);
    
    
    
}
