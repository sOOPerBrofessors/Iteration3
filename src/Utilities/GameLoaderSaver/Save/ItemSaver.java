package Utilities.GameLoaderSaver.Save;

import Model.Items.Interactable.Interactable;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon.Weapon;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Location;
import Utilities.ItemStuff.ItemManager;
import Utilities.Visitor.ItemVisitor;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by dyeung on 4/17/16.
 */
public class ItemSaver implements ItemVisitor {
    private final Document doc;
    private final ArrayList<Element> list;
    //SKETCHY WAY TO DO THIS SORRY
    private String tmpLocation;
    public ItemSaver(Document document ) {
        this.doc = document;
        list = new ArrayList<>();
        tmpLocation = "UNDEFINED";
    }
    public ArrayList<Element> getItems(ItemManager itemManager){
        list.clear();

        HashMap<Location, TakeableItem> tmp = itemManager.getMapTakableItems();
        Iterator it = tmp.entrySet().iterator();
        //Test to see
        while (it.hasNext()) {
            HashMap.Entry pair = (HashMap.Entry)it.next();
            System.out.println(pair.getKey() + " = " + pair.getValue());
            tmpLocation = pair.getKey().toString();
            ((Item)pair.getValue()).acceptItemVisitor(this);
        }
        return list;
    }

    @Override
    public void visitTakeableItem(TakeableItem item) {
        Element element = doc.createElement("Takeable-Item");
        element.setAttributeNode(SaverUtility.getAttrWithSS(doc, item.getName()));
        Attr location = doc.createAttribute("location");
        location.setValue(tmpLocation);
        element.setAttributeNode(location);
        list.add(element);
    }

    @Override
    public void visitInteractive(Interactable item) {
        Element element = doc.createElement("Interactable-Item");
        element.setAttributeNode(SaverUtility.getAttrWithSS(doc, item.toString()));
        Attr location = doc.createAttribute("location");
        location.setValue(tmpLocation);
        element.setAttributeNode(location);
        list.add(element);
    }

    @Override
    public void visitEquippableArmor(Armor armor) {

    }

    @Override
    public void visitEquippableWeapon(Weapon weapon) {

    }
}
