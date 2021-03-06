package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow summoners to equip summoner weapons
 */
public class SummonerWeaponStrategy extends EquippableStrategy {
    public boolean onInteract(TakeableItem item, Character character) {
        character.equipSummonerWeapon((Weapon)item);
        return true;
    } // end onInteract
} // end class SummonerWeaponStrategy
