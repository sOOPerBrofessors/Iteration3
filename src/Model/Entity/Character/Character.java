package Model.Entity.Character;

import Model.Entity.Character.Occupation.Occupation;
import Model.Entity.Character.Occupation.OccupationStrategy.OccupationStrategy;
import Model.Entity.Entity;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;

/**
 * Created by broskj on 4/6/16.
 *
 * Abstract class to act as the superclass to the player (Avatar) and NPCs.
 */
public abstract class Character extends Entity{
    private Occupation o;
    private OccupationStrategy s;

    protected Character(Occupation o, OccupationStrategy s) {
        this.o = o;
        this.s = s;
    } // end private constructor

    public void equipWeapon(Weapon weapon) {
        // pack.equipWeapon(weapon);
    } // end equipArmor

    public void equipArmor(Armor armor) {
        // pack.equipArmor(armor);
    } // end equipArmor

    public void equipSmasherWeapon(Weapon weapon) {
        s.equipSmasherWeapon();
    } // end equipSmasherWeapon
    public void equipSmasherArmor(Armor armor) {
        s.equipSmasherArmor();
    } // end equipSmasherArmor
    public void equipSneakWeapon(Weapon weapon) {
        s.equipSneakWeapon();
    } // end equipSneakWeapon
    public void equipSneakArmor(Armor armor) {
        s.equipSneakArmor();
    } // end equipSneakArmor
    public void equipSummonerWeapon(Weapon weapon) {
        s.equipSummonerWeapon();
    } // end equipSummonerWeapon
    public void equipSummonerArmor(Armor armor) {
        s.equipSummonerArmor();
    } // end equipSummonerArmor
} // end abstract class Character
