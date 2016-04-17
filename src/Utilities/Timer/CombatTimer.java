package Utilities.Timer;

import Controller.ControllerUtility.Command;
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
        super(5000, HUD::setStatusCombat, e -> HUD.setStatusRegular());
    } // end constructor
}
