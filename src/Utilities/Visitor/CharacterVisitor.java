package Utilities.Visitor;

import Model.Entity.Character.Occupation.Occupation;
import Model.Inventory.Inventory;
import Model.Stats.CharacterStats;

/**
 * Created by dyeung on 4/9/16.
 */
public interface CharacterVisitor {

    void visitInventory(Inventory inventory);
    void visitOccupation(Occupation occupation);
    void visitStats(CharacterStats stats);
}

