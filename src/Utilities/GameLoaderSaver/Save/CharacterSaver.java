package Utilities.GameLoaderSaver.Save;

import Model.Entity.Character.Character;
import Model.Entity.Character.Occupation.Occupation;
import Model.Inventory.Inventory;
import Model.Skills.Skill;
import Model.Stats.CharacterStats;
import Utilities.Visitor.CharacterVisitor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/16/16.
 */
public class CharacterSaver implements CharacterVisitor {
    private Document doc;
    private ArrayList<Element> characterList;
    CharacterSaver(Document document){
        characterList = new ArrayList<>();
        this.doc = document;
    }

    public ArrayList<Element> getElementsList(Character character){
        characterList.clear();
        character.acceptCharacterVisitor(this);
        return characterList;
    }
    @Override
    public void visitInventory(Inventory inventory) {
        InventorySaver invSave = new InventorySaver(doc, inventory);
        Element inv = doc.createElement("Inventory");

        Element pack = doc.createElement("Pack");
        ArrayList<Element> packList = invSave.getPack();
        for(Element element : packList){
            pack.appendChild(element);
        }
        inv.appendChild(pack);

        Element equip = doc.createElement("Equip");
        ArrayList<Element> equipList = invSave.getEquipped();
        for(Element element : equipList){
            equip.appendChild(element);
        }
        inv.appendChild(equip);

        //Inventory is adde to character list
        characterList.add(inv);
    }

    @Override
    public void visitOccupation(Occupation occupation) {

    }

    @Override
    public void visitStats(CharacterStats stats) {

    }

    @Override
    public void visitSkills(Skill[] skills) {

    }


}
