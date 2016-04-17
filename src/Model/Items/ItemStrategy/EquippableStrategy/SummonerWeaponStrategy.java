package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Weapon.Weapon;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow summoners to equip summoner weapons
 */
public class SummonerWeaponStrategy extends EquippableStrategy {
    public void onInteract(Item item, Character character) {
        character.equipSummonerWeapon((Weapon)item);
    } // end onInteract
} // end class SummonerWeaponStrategy
