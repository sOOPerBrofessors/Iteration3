package Utilities.GameLoaderSaver.Save;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Character.NPC.NPC;
import Model.Items.Item;
import Model.Items.Takeable.TakeableItem;
import Model.Map.AreaEffect.*;
import Model.Map.Location;
import Model.Entity.Projectile.Projectile;
import Model.Map.AreaEffect.AreaOfEffect;

import Model.Map.Map;
import Model.Map.Tile.Terrain.Terrain;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Location;
import Model.State.GameState.GameState;
import Utilities.ItemStuff.ItemManager;
import Utilities.Visitor.*;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by dyeung on 4/16/16.
 */
public class SaveVisitor implements TileVisitor, CharacterTypeVisitor {
    private String fileNamePath;
    private GameState gameState;
    private  ArrayList<Element> list;
    private Document doc;
    private Map map;
    private Avatar avatar;
    private Element mainRootElement;
    public SaveVisitor(String fileName, GameState gameState){
        this.fileNamePath = fileName;
        this.gameState = gameState;
        this.map = gameState.getMap();
        this.avatar = gameState.getAvatar();
        list = new ArrayList<>();
        init();
    }
    private void init(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();

            mainRootElement = doc.createElementNS(fileNamePath, "Save_File");
            doc.appendChild(mainRootElement);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void save(){
        list.clear();
//        Element element = saveCharacters();
//        mainRootElement.appendChild(element);
        saveCharacters();
        saveItems();


        //Write to XML
        writeToXml(doc, fileNamePath);
    }
    public Element saveCharacters() {
        Element e = doc.createElement("Characters");

        for(int i = 0; i < map.getMaxRow(); i++){
            for(int j = 0; j < map.getMaxColumn(); j++){
                for (int k = 0; k < 10; k++){
                    map.getTileAt(i,j,k).acceptTileVisitor(this);
                }
            }
        }

        return e;
    }
    public Element saveItems(){
        Element e = doc.createElement("Map-Items");
        ItemManager itemManager = gameState.getItemManager();
        ItemSaver itemSaver = new ItemSaver(doc);
        ArrayList<Element> tmp = itemSaver.getItems(itemManager);
        for(Element element : tmp){
            e.appendChild(element);
        }

        mainRootElement.appendChild(e);
        return e;
    }


    @Override
    public void visitTileHasMount(Mount mount) {

    }

    @Override
    public void visitTileTerrain(Terrain terrain) {

    }

    @Override
    public void visitTileHasCharacter(Character character) {
        if(character != null) {
            character.acceptCharacterTypeVisitor(this);
        }
    }

    //Might not need to do AOE since the map never changes its AOE
    @Override
    public void visitTileHasAOE(AreaOfEffect areaOfEffect) {

    }


    //Unnecessary for projectiles
    @Override
    public void visitTileHasProjectile(Projectile projectile) {

    }


    //----------Function to transform saved (doc) into Xml and the Console -------
    private void writeToXml(Document doc, String fileName) {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try {
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(fileName));

            //Formats it nicely (5 is the max number of child nodes
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformerFactory.setAttribute("indent-number", 5);
            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount",
                    Integer.toString(5));
            transformer.transform(source, result);

            //Output to console for testing
            //StreamResult consoleResult = new StreamResult(System.out);
            //transformer.transform(source, consoleResult);
            System.out.println("SaveVisitor: Saved success!");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitAvatar(Avatar avatar) {
        CharacterSaver characterSaver = new CharacterSaver(doc);
        ArrayList<Element> tmp = characterSaver.getElementsList(avatar);
        Element element = doc.createElement("Avatar");
        internalCharAttr(element, avatar);
        doSkillsForAvatar(element, avatar);
        for(Element elm : tmp){
            element.appendChild(elm);
        }
        mainRootElement.appendChild(element);
    }

    @Override
    public void visitNPC(NPC npc) {
        CharacterSaver characterSaver = new CharacterSaver(doc);
        ArrayList<Element> tmp = characterSaver.getElementsList(npc);
        Element element = doc.createElement("NPC");
        internalCharAttr(element, npc);
        for(Element elm : tmp){
            element.appendChild(elm);
        }
        mainRootElement.appendChild(element);
    }

    private void internalCharAttr(Element element, Character character){
        Attr locAttr = doc.createAttribute("location");
        locAttr.setValue(character.getLocation().toString());
        element.setAttributeNode(locAttr);
        Attr occupationAttr = doc.createAttribute("occupation");
        occupationAttr.setValue(character.getOccupation().toString());
        element.setAttributeNode(occupationAttr);
        Attr orientationAttr = doc.createAttribute("orientation");
        orientationAttr.setValue(character.getOrientation().toString());
        element.setAttributeNode(orientationAttr);
    }

    private void doSkillsForAvatar(Element element, Avatar avatar){
        Element skillsElement = doc.createElement("Skills");

        element.appendChild(skillsElement);
    }
}
