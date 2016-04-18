package Utilities.GameLoaderSaver.Load;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.Character;
import Model.Entity.Character.NPC.NPC;
import Model.Entity.Character.Occupation.Occupation;
import Model.Items.Item;
import Model.Items.Takeable.TakeableItem;
import Model.Map.Location;
import Model.Map.Map;
import Utilities.IOUtilities;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dyeung on 4/17/16.
 */
public class LoadParser {
    private Document doc;
    //For better usage I might need a file name to handle this
//    public static void main(String[] args) {
//        LoadParser lp = new LoadParser();
//        lp.loadAvatar();
//        lp.loadItemMap();
//    }
    public LoadParser(){
        String updateFile = "./res/SaveFile/SaveFile1.xml" ;
        String filePath = IOUtilities.getFileSystemDependentPath(updateFile);
        System.out.println(filePath);

        try {
            // Create a document from the xml file
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = documentBuilderFactory.newDocumentBuilder();
            doc = docBuilder.parse(new File(filePath));

            // Normalize
            doc.getDocumentElement().normalize();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Item> loadItems(){
        ArrayList<Item> tmp = new ArrayList<>();

        NodeList itemList = doc.getElementsByTagName("Takeable-Item");
        LoadItems loadItems = new LoadItems();
        loadItems.loadTakeableItem(itemList);

        return tmp;
    }
    public Avatar loadAvatar(){
        NodeList avatarList = doc.getElementsByTagName("Avatar");
        Element avatarElm = (Element) avatarList.item(0);
        LoadCharacters loadCharacters = new LoadCharacters();

        Avatar avatar = loadCharacters.convertToAvatar(avatarElm);

        return avatar;
    }
    //Doesnt work now
    public ArrayList<NPC> loadNPC(){
        ArrayList<NPC> npcList = new ArrayList<>();

        NodeList npcNodeList = doc.getElementsByTagName("NPC");
        LoadCharacters loadCharacters = new LoadCharacters();

        for (int i = 0; i < npcNodeList.getLength(); i++) {
            Element npcElm = (Element) npcNodeList.item(i);
            NPC npc = loadCharacters.convertToCharacter(npcElm);
            npcList.add(npc);
        }
        return npcList;
    }


}
