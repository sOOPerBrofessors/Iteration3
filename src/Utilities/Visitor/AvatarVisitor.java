package Utilities.Visitor;

import Model.Inventory.Inventory;

/**
 * Created by dyeung on 4/16/16.
 */
public interface AvatarVisitor {
    void visitInventory(Inventory inventory);
    void visitEquipment();
    void visitOccupation();
    void visitStats();
}
