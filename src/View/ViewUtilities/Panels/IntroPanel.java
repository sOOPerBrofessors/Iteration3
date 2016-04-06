package View.ViewUtilities.Panels;

import View.ViewManager;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wimberley on 4/6/16.
 */
public class IntroPanel extends JPanel {

    private static JPanel introPanel;

    public IntroPanel(ViewManager viewManager){
        introPanel = titlePanel(viewManager);
    }

    private JPanel titlePanel(final ViewManager viewManager){

        // create JPanel with grid layout
        JPanel title = new JPanel(new GridBagLayout());

        // create buttons on intro screen
        JButton newGame = new JButton("New Game");
        JButton loadGame = new JButton("Load Game");
        JButton exitGame = new JButton("Exit Game");

        // switch to character creation state when new game button is pressed
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch state
                //viewManager.;
            }
        });

        // switch to load state when load game button is pressed
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // switch state
                //viewManager.;
            }
        });

        // close game when exit button is pressed
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.exitGame();
            }
        });

        // set constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15,15,15,15);

        // add buttons to panel
        constraints.gridy = 0;
        title.add(newGame, constraints);
        constraints.gridy = 1;
        title.add(loadGame, constraints);
        constraints.gridy = 2;
        title.add(exitGame, constraints);

        return title;
    }

    public static JPanel getIntroPanel(){
        return introPanel;
    }
}
