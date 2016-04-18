package Utilities.GameLoaderSaver.Load;

import Model.Items.Takeable.Quest;
import Model.Map.Location;
import Utilities.ItemStuff.ItemFactory.ItemFactory;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.HashMap;

/**
 * Created by dyeung on 4/17/16.
 */
public class LoadItems {
    HashMap<String, Runnable> itemCreateCommand;
    public LoadItems(){
        itemCreateCommand = new HashMap<>();
        init();
    }
    private void init(){
        itemCreateCommand.put("Basic-Health-Potion", () -> ItemFactory.makeBasicHealthPotion());
        itemCreateCommand.put("Wooden-Sword", () -> ItemFactory.makeWoodenSword());
        itemCreateCommand.put("Light-Armor", () -> ItemFactory.makeLightArmor());
        itemCreateCommand.put("Key", () -> Quest.makeKey());

    }
    public void loadTakeableItem(NodeList itemList){
        for (int i = 0; i < itemList.getLength(); i++){
            Element itemElm = (Element)itemList.item(i);
            getItemFromElement(itemElm);
        }
    }
    private void getItemFromElement(Element itemElement){
        String loc = itemElement.getAttribute("location");
        String delims = ",";
        String[] tokens = loc.split(delims);
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        int z = Integer.parseInt(tokens[2]);
        Location location = new Location(x,y,z);

        itemElement.getAttribute("name");

    }

}
