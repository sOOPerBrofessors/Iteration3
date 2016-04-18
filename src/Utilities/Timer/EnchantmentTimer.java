package Utilities.Timer;

import Model.Entity.Character.Character;
import Utilities.GameMessageQueue;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class EnchantmentTimer extends TimedEvent {
    public EnchantmentTimer(int durationMilli, Character enemy) {
        super(durationMilli,
                () -> enemy.movementEffect(-10),
                e -> {
                    enemy.movementEffect(10);
                    GameMessageQueue.push("Enemy at (" + enemy.getX() + ", " + enemy.getY() + ") is no longer slowed down!");
                }
        );
    } // end constructor
}
