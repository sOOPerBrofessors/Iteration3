package Model.Skills.RangedSkills;

import Model.Entity.Character.Avatar;
import Model.Entity.Projectile.Projectile;
import Model.Map.Location;
import Model.State.GameState.ActiveGameState;

/**
 * Created by AndyZhu on 13/4/2016.
 */
public class RangedWeapon extends RangedSkill{
    public RangedWeapon(Avatar avatar) {
        super(avatar);
        name = "Ranged weapon";
        manaCost = 1;
        coolDownTime = 1;
    }


    public void execute(ActiveGameState activeGameState) {
        if (allConditionChecked()) {
            calculateRangedWeaponDamage();
            Location tempLoc = new Location(avatar.getX(), avatar.getY(), avatar.getZ());
            activeGameState.getProjectiles().add(Projectile.makeFireBall(tempLoc, avatar.getOrientation(), damage));
            enforceManaCost();
            setTimePerformed();
        }
    }

    private void calculateRangedWeaponDamage() {
        damage = level * avatar.getAgility();
    }
}
