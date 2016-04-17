package Utilities.Visitor;

import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;

/**
 * Created by dyeung on 4/16/16.
 */
public interface ItemVisitor {
    void visitTakeableItem(TakeableItem item);
    //void visitObstacle(Obstacle item);
    void visitInteractive(Interactable item);
    void visitEquippableArmor(Armor armor);
    void visitEquippableWeapon(Weapon weapon);
    //void visitOneShot(OneShot item);
}
