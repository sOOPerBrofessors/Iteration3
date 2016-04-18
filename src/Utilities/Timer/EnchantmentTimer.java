package Utilities.Timer;

import Model.Entity.Character.Character;
import Model.Skills.SkillsWithDuration.Boon;
import Utilities.GameMessageQueue;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class EnchantmentTimer extends TimedEvent {
    public EnchantmentTimer(int durationMilli, Character enemy, int modifier) {
        super(durationMilli,
                () -> enemy.movementEffect(-modifier),
                e -> {
                    enemy.movementEffect(modifier);
                    GameMessageQueue.push("Enemy at (" + enemy.getX() + ", " + enemy.getY() + ") is no longer slowed down!");
                }
        );
    } // end constructor
}
