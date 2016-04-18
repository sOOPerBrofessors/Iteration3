package View.ViewUtilities.Panels;

import View.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wimberley on 4/6/16.
 */
public class IntroPanel extends JPanel {

    private static JPanel introPanel;
    private final ViewManager viewManager;

    public IntroPanel(ViewManager viewManager){
        introPanel = introPanel();
        this.viewManager = viewManager;
    }

    public JPanel introPanel(){

        // create JPanel with grid layout
        JPanel title = new JPanel(new GridBagLayout());

        // create buttons on intro screen
        JButton newGame = new JButton(new ImageIcon("./res/Buttons/NewGame.png"));
        newGame.setPreferredSize(new Dimension(200, 50));
        JButton loadGame = new JButton(new ImageIcon("./res/Buttons/LoadGame.png"));
        loadGame.setPreferredSize(new Dimension(200, 50));
        JButton exitGame = new JButton(new ImageIcon("./res/Buttons/ExitGame.png"));
        exitGame.setPreferredSize(new Dimension(200, 50));

        // switch to character creation state when new game button is pressed
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.displayCreate();
                //viewManager.;
            }
        });

        // switch to load state when load game button is pressed
        loadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.loadGame();
            }
        });

        // close game when exit button is pressed
        exitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
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

    @Override
    public void paint(Graphics g){
        // calls JPanel paint method on g (deletes old image)
        super.paint(g);

        // paint some stuff
    }

    public static JPanel getIntroPanel(){
        return introPanel;
    }
}
