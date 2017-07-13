/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.bigFishChallenge.view;

import static bigfishchallenge.BigFishChallenge.playGame;

/**
 *
 * @author Cody
 */
public class LoseGameView extends View {
    public LoseGameView() {
        super("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
            + "\n^^^^^^^^^^^^^^^^^^^^"
            + "\n--------------------"
            + "\n    OUT OF GAS!"
            + "\n    Game  Over"
            + "\n--------------------"
            + "\n<><><><><><><><><><>"
            + "\n\nWant to play again? (Y or N)");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // convert choice to upper case

        switch (value) {
            case "Y":
                playGame();
                break;
            case "N":
                System.exit (0);
                break;
            default:
                ErrorView.display(this.getClass().getName(), "\n*** Invalid selection *** Try again");
                break;

        }

        return false;
    }

    

}
