package Utilities.GameLoaderSaver.Save;

import Model.Inventory.Equipment;
import Model.Inventory.Inventory;
import Model.Inventory.Pack;
import Model.Items.Interactable.Interactable;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Utilities.Visitor.ItemVisitor;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/16/16.
 */
public class InventorySaveVisitor implements ItemVisitor {
    Document doc;
    ArrayList<Element> list;
    Inventory inventory;
    public InventorySaveVisitor(Document doc, Inventory inventory) {
        this.doc = doc;
        list = new ArrayList<>();
        this.inventory = inventory;
    }
    public ArrayList<Element> getPack(){
        list.clear();
        Pack pack = inventory.getPack();
        for(int i = 0; i < pack.size(); i++){
            pack.getItemAt(i).acceptItemVisitor(this);
        }
        return list;
    }
    public ArrayList<Element> getEquipped(){
        list.clear();
        Equipment pack = inventory.getEquipment();
        pack.getArmor().acceptItemVisitor(this);
        pack.getWeapon().acceptItemVisitor(this);
        return list;
    }

    @Override
    public void visitTakeableItem(TakeableItem item) {
        Element element = doc.createElement("Takeable-Item");
        Attr name = doc.createAttribute("name");
        Attr descr = doc.createAttribute("description");
        name.setValue(item.getName());
        descr.setValue(item.getDescription());
        list.add(element);
    }

    @Override
    public void visitInteractive(Interactable item) {

    }

    @Override
    public void visitEquippableArmor(Armor armor) {

    }

    @Override
    public void visitEquippableWeapon(Weapon weapon) {

    }
}
