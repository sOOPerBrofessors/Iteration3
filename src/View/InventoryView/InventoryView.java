package View.InventoryView;

import Model.Entity.Entity;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.State.GameState.ActiveGameState;
import Utilities.Observers.EntityObservable;
import Utilities.Observers.EntityObserver;
import Utilities.Observers.Observer;
import Utilities.Settings;
import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sgl on 4/9/16.
 */

//Displays Inventory in 4x4 matrix. x goes to the right, y goes down
public class InventoryView extends JComponent implements Observer{

    private Inventory inventory;
    //private ArrayList<Item> inventoryList;
    //private Armor equippedArmor;
    //private Weapon equippedWeapon;
    private HashMap<Item, BufferedImage> itemViewMap;
    private ArrayList<BufferedImage> itemViewList;
    private BufferedImage weaponImage;
    private BufferedImage armorImage;
    private int xSel, ySel, xMax, yMax;


    public InventoryView(ActiveGameState gameState){
        inventory = gameState.getAvatar().getInventory();
        //add items with respective image to itemViewMap
        //this.inventoryList =  inventory.getPack().getItems(); // TODO: Fix the LOD VIOLATION!!! (Is there a fix?)
        //this.equippedArmor = inventory.getEquipment().getArmor();
        //this.equippedWeapon = inventory.getEquipment().getWeapon();
        ySel = 0;
        xSel = 0;
        xMax = Settings.MAX_INVENTORY_SIZE/4;
        yMax = Settings.MAX_INVENTORY_SIZE/4;
    }

    public void selectRight(){ if (xSel < 4) xSel++; }

    public void selectLeft(){ if (xSel>0) xSel--; }

    public void selectUp(){ if (ySel>0) ySel--; }

    public void selectDown(){ if (ySel<4) ySel++; }

    public void interactWithItem(){ //MAKE SURE INVENTORY HANDLES ERROR CHECKING IF TRYING TO USE AN ITEMSLOT THAT ISN'T FILLED!!!
        //y*4+x
        //inventory.
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.ORANGE);
        g.drawRect(200,200,200,200);
    }


    @Override
    public void update() {
        //inventory.
    }

    @Override
    public void remove() {

    }
}
