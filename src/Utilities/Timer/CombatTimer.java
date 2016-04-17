package Utilities.Timer;

import Controller.ControllerUtility.Command;
import Utilities.TimedEvent;
import View.AreaViewport.HUDView.HUD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by broskj on 4/16/16.
 *
 * Class to be used by characters to determine when to render health bar.
 */
public class CombatTimer extends TimedEvent {
    public CombatTimer() {
        super(5000, new Command() {
            @Override
            public void execute() {
                HUD.setStatusCombat();
            }
        }, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HUD.setStatusRegular();
            }
        });
    } // end constructor
}
