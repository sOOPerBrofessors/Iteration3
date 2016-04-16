package Utilities.GameLoaderSaver.Save;

import Model.Inventory.Inventory;
import Model.Inventory.Pack;
import Utilities.Visitor.AvatarVisitor;
import Utilities.Visitor.ItemVisitor;
import org.w3c.dom.Element;

/**
 * Created by dyeung on 4/16/16.
 */
public class AvatarSaveVisitor implements AvatarVisitor, ItemVisitor {
    AvatarSaveVisitor(){

    }
    @Override
    public void visitInventory(Inventory inventory) {
        //Element inv = doc.createElement("Inventory");
        Pack pack = inventory.getPack();
        for(int i = 0; i < pack.size(); i++) {
            pack.getItemAt(i).acceptItemVisitor(this);
        }
    }

    @Override
    public void visitEquipment() {

    }

    @Override
    public void visitOccupation() {

    }

    @Override
    public void visitStats() {

    }

    @Override
    public void visitTakeableItem() {

    }

    @Override
    public void visitObstacle() {

    }

    @Override
    public void visitInteractive() {

    }

    @Override
    public void visitOneShot() {

    }
}
