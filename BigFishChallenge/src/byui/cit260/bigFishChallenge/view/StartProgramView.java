/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;


public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        this.promptMessage = "\nPlease enter your name: ";
        
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
        "\n***************************************************"
        +"\n*                                                 *"
        +"\n*             BIG FISH CHALLENGE                  *"
        +"\n*                                                 *"
        +"\n*                    /`-._                        *"
        +"\n*                   /_,.._`:-                     *"
        +"\n*               ,.-'  ,   `-:..-')                *"
        +"\n*              : o ):';      _  {                 *"
        +"\n*               `-._ `'__,.-'\\`-.)                *"
        +"\n*                   `\\\\  \\,.-'`                   *"
        +"\n*                                                 *"
        +"\n* The Annual Fishing Championship has arrived in  *"
        +"\n* Arkansas. It's time for you to get your line in *"
        +"\n* the water and prove that you've got what it     *"
        +"\n* takes to be a champion!                         *"
        +"\n*                                                 *"
        +"\n* Spend your money on bait and fuel and get out   *"
        +"\n* on the water. Try fishing all over the lake,    *"
        +"\n* but keep an eye on your resources. You'll have  *"
        +"\n* to head back to the marina to stock up.         *"
        +"\n*                                                 *"
        +"\n* As you try your luck around the lake, be sure   *"
        +"\n* to talk to other fishermen, who can give you    *"
        +"\n* pointers on where to find the 'big ones'.       *"
        +"\n*                                                 *"
        +"\n*       Be safe, and good luck out there!         *"
        +"\n*                                                 *"
        +"\n***************************************************"
        );
    }

    public void displayStartProgramView() {
        System.out.println("\n*** displayStartProgram() function called ***");
    }
    
        
}
