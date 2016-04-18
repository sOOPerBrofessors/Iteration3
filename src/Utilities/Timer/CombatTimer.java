package Utilities.Timer;

import View.AreaViewport.HUDView.HUD;

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
