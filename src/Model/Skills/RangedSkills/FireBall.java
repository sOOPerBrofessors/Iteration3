package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Projectile.Projectile;
import Model.Map.Location;
import Model.Map.Map;
import Model.State.GameState.ActiveGameState;

/**
 * Created by AndyZhu on 17/4/2016.
 */
public class Fireball extends RangedSkill {

    public Fireball(Avatar avatar) {
        super(avatar);
        name = "Fireball";
        manaCost = 1;
        coolDownTime = 1;

    }

    public void execute(ActiveGameState activeGameState) {
        if (allConditionChecked()) {
            calculateDamage();
            Location tempLoc = new Location(avatar.getX(), avatar.getY(), avatar.getZ());
            activeGameState.getProjectiles().add(Projectile.makeFireBall(tempLoc, avatar.getOrientation(), damage));
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void calculateDamage() {
        damage = level * avatar.getIntellect();
    }
}
