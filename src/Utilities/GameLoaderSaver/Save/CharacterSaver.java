package Utilities.GameLoaderSaver.Save;

import Model.Entity.Character.Character;
import Model.Entity.Character.Occupation.Occupation;
import Model.Inventory.Inventory;
import Model.Stats.CharacterStats;
import Utilities.Visitor.CharacterVisitor;
import org.w3c.dom.Attr;
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
        //Visitor is actually unecessary but w.e
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
        Element occElement = doc.createElement("occupation");
        characterList.add(occElement);
    }

    @Override
    public void visitStats(CharacterStats stats) {
        //Not sure if better way to do this (maybe a loop?)
        Element statElm = doc.createElement("Stats");

        Attr agilityStats = doc.createAttribute("agility");
        agilityStats.setValue(Integer.toString(stats.getAgility()));
        statElm.setAttributeNode(agilityStats);

        Attr experience = doc.createAttribute("experience");
        experience.setValue(Integer.toString(stats.getExperience()));
        statElm.setAttributeNode(experience);

        Attr hardiness = doc.createAttribute("hardiness");
        hardiness.setValue(Integer.toString(stats.getHardiness()));
        statElm.setAttributeNode(hardiness);

        Attr intellect = doc.createAttribute("intellect");
        intellect.setValue(Integer.toString(stats.getIntellect()));
        statElm.setAttributeNode(intellect);

        Attr lives = doc.createAttribute("lives");
        lives.setValue(Integer.toString(stats.getLives()));
        statElm.setAttributeNode(lives);

        Attr strength = doc.createAttribute("strength");
        strength.setValue(Integer.toString(stats.getStrength()));
        statElm.setAttributeNode(strength);

        Attr health = doc.createAttribute("health");
        health.setValue(Integer.toString(stats.getHealth()));
        statElm.setAttributeNode(health);

        Attr mana = doc.createAttribute("mana");
        mana.setValue(Integer.toString(stats.getMana()));
        statElm.setAttributeNode(mana);

    //Base stuff
        Attr baseAgilityStats = doc.createAttribute("base-agility");
        baseAgilityStats.setValue(Integer.toString(stats.getBaseAgility()));
        statElm.setAttributeNode(baseAgilityStats);

        Attr baseHardiness = doc.createAttribute("base-hardiness");
        baseHardiness.setValue(Integer.toString(stats.getBaseHardiness()));
        statElm.setAttributeNode(baseHardiness);

        Attr baseIntellect = doc.createAttribute("base-intellect");
        baseIntellect.setValue(Integer.toString(stats.getBaseIntellect()));
        statElm.setAttributeNode(baseIntellect);

        Attr baseLive = doc.createAttribute("base-lives");
        baseLive.setValue(Integer.toString(stats.getBaseLives()));
        statElm.setAttributeNode(baseLive);

        Attr baseStrength = doc.createAttribute("base-strength");
        baseStrength.setValue(Integer.toString(stats.getBaseStrength()));
        statElm.setAttributeNode(baseStrength);

        Attr baseHealth = doc.createAttribute("base-health");
        baseHealth.setValue(Integer.toString(stats.getBaseHealth()));
        statElm.setAttributeNode(baseHealth);

        Attr baseMana = doc.createAttribute("base-mana");
        baseMana.setValue(Integer.toString(stats.getBaseMana()));
        statElm.setAttributeNode(baseMana);

        characterList.add(statElm);


    }




}
