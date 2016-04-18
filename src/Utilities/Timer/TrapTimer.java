package Utilities.Timer;

import Model.Entity.Character.Character;
import Model.Skills.RangedSkills.ObservationInfo;
import Utilities.GameMessageQueue;
import View.SkillView.ObservedNPC;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class TrapTimer extends TimedEvent {
    public TrapTimer(Character character) {
        super(5000,
                () -> {
                    character.movementEffect(-3);
                    GameMessageQueue.push("Oops! You are slowed down");
                },
                e -> {
                    character.movementEffect(3);
                    GameMessageQueue.push("You are no longer slowed down");
                });
    } // end constructor
}
