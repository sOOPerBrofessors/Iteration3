package Utilities.Timer;

import Model.Map.Map;
import Model.Skills.RangedSkills.ArcaneExplosion;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class SecondArcaneExplosionTimer extends TimedEvent {
    public SecondArcaneExplosionTimer(ArcaneExplosion arcaneExplosion, Map map) {
        super(400,
                () -> arcaneExplosion.secondArcaneExplosion(map),
                e -> arcaneExplosion.endArcaneExplosion()
        );
    } // end constructor
}
