package Utilities.Timer;

import Model.Skills.RangedSkills.EarthShake;
import Model.Map.Map;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class EarthShakeTimer extends TimedEvent {
    public EarthShakeTimer(EarthShake earthShake, Map map) {
        super(400,
                () -> earthShake.activateEarthShake(map),
                e -> earthShake.endEarthShake()
        );
    } // end constructor
}
