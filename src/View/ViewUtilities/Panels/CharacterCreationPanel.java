package View.ViewUtilities.Panels;

import View.ViewManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Wimberley on 4/7/16.
 */
public class CharacterCreationPanel extends JPanel {

    private static JPanel createPanel;
    private ViewManager viewManager;

    public CharacterCreationPanel(ViewManager viewManager){
        createPanel = createPanel();
        this.viewManager = viewManager;
    }

    public JPanel createPanel(){

        // create JPanel with grid layout
        JPanel create = new JPanel(new GridBagLayout());

        // create buttons on intro screen
        JButton smasher = new JButton("Smasher");
        JButton sneak = new JButton("Sneak");
        JButton summoner = new JButton("Summoner");

        // switch to character creation state when new game button is pressed
        smasher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.createSmasher();
            }
        });

        // switch to load state when load game button is pressed
        sneak.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.createSneak();
            }
        });

        // close game when exit button is pressed
        summoner.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewManager.createSummoner();
            }
        });

        // set constraints
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(15,15,15,15);

        // add buttons to panel
        constraints.gridy = 0;
        create.add(smasher, constraints);
        constraints.gridy = 1;
        create.add(sneak, constraints);
        constraints.gridy = 2;
        create.add(summoner, constraints);

        return create;
    }

    @Override
    public void paint(Graphics g){
        // calls JPanel paint method on g (deletes old image)
        super.paint(g);

        // paint some stuff
    }

    public static JPanel getCreatePanel(){
        return createPanel;
    }
}