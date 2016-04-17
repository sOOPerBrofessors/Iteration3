package Utilities.GameLoaderSaver.Save;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPC;
import Model.Map.AreaEffect.*;
import Model.Map.Map;
import Model.Map.Tile.Terrain.Terrain;
import Model.Projectile.Projectile;
import Model.State.GameState.GameState;
import Utilities.Observers.EntityObserver;
import Utilities.Visitor.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by dyeung on 4/16/16.
 */
public class SaveVisitor implements TileVisitor, EntityObserver, CharacterTypeVisitor {
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
    }
    public void save(){
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            doc = docBuilder.newDocument();

            mainRootElement = doc.createElementNS(fileNamePath, "Save_File");
            doc.appendChild(mainRootElement);

            ArrayList<Element> listOfElements = saveAvatarElements();

            for(Element element : listOfElements){
                mainRootElement.appendChild(element);
            }

            //Originally was done so that each entity will be a list (no longer the case but possibly a better change)
            //mainRootElement.appendChild(saveEntities(doc, avatar));

            //Write to XML
            writeToXml(doc, fileNamePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ArrayList<Element> saveAvatarElements() {
//        Avatar avatar = gameState.getAvatar();
//        avatar.acceptCharacterVisitor(this);

        return list;
    }

    @Override
    public void updateMove() {

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
            System.out.println("Saved success!");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void visitAvatar(Avatar avatar) {
        CharacterSaveVisitor characterSaveVisitor = new CharacterSaveVisitor(doc);
        ArrayList<Element> tmp = characterSaveVisitor.getElementsList(avatar);
        Element element = doc.createElement("Avatar");
        for(Element elm : tmp){
            element.appendChild(elm);
        }
        mainRootElement.appendChild(element);
    }

    @Override
    public void visitNPC(NPC npc) {
        CharacterSaveVisitor characterSaveVisitor = new CharacterSaveVisitor(doc);
        ArrayList<Element> tmp = characterSaveVisitor.getElementsList(npc);
        Element element = doc.createElement("NPC");
        for(Element elm : tmp){
            element.appendChild(elm);
        }
        mainRootElement.appendChild(element);
    }
}
