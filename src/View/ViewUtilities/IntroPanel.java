package View.ViewUtilities;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Wimberley on 4/6/16.
 */
public class IntroPanel extends JPanel {

    private static JPanel introPanel;

    public IntroPanel(){
        introPanel = titlePanel();
    }

    private JPanel titlePanel(){

        // create JPanel with grid layout
        JPanel title = new JPanel(new GridBagLayout());

        // create buttons on intro screen
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton exitGame = new JButton("Exit Game");

        // set constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15,15,15,15);

        // add buttons to panel
        title.add(newGame, constraints);
        title.add(loadGame, constraints);
        title.add(exitGame, constraints);

        return title;
    }

    public static JPanel getIntroPanel(){
        return introPanel;
    }
}
