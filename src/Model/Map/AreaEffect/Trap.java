package Model.Map.AreaEffect;

import Model.Entity.Character.Character;
import Utilities.Timer.TrapTimer;
import Utilities.Visitor.AOEVisitor;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class Trap extends AreaOfEffect{
        //This is kinda bad to have to know map but its the only way to move/jump
        public Trap() {
            super(1);
            alpha = 0f;
        }

        @Override
        public void onInteract(Character character) {
            if (active) {
                new TrapTimer(character).start();
            }
        }

        @Override
        public void acceptAOEVisitor(AOEVisitor aoeVisitor) {
            aoeVisitor.visitTrap();
        }
}
