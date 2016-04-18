package Utilities.Timer;

import Model.Map.Map;
import Model.Skills.RangedSkills.ArcaneExplosion;
import Model.Skills.RangedSkills.EarthShake;

/**
 * Created by AndyZhu on 18/4/2016.
 */
public class ArcaneExplosionTimer extends TimedEvent {
    public ArcaneExplosionTimer(ArcaneExplosion arcaneExplosion, Map map) {
        super(400,
                () -> arcaneExplosion.activateArcaneExplosion(map),
                e -> arcaneExplosion.setSecondArcaneExplosion(map)
        );
    } // end constructor
}
