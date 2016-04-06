package Model.Items.ItemStrategy.EquippableStrategy;

import Model.Entity.Character.Character;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;

/**
 * Created by broskj on 4/6/16.
 *
 * Class to allow summoners to equip summoner armor
 */
public class SummonerArmorStrategy extends EquippableStrategy {
    public void onInteract(Item item, Character character) {
        character.equipSummonerArmor((Armor)item);
    } // end onInteract
} // end class SummonerArmorStrategy
