package View.InventoryView;

import Model.Entity.Entity;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.Items.Takeable.Equippable.Armor;
import Model.Items.Takeable.Equippable.Weapon;
import Model.State.GameState.ActiveGameState;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Observers.EntityObservable;
import Utilities.Observers.EntityObserver;
import Utilities.Observers.Observer;
import Utilities.PersonFilter;
import Utilities.Settings;
<<<<<<< HEAD
//import javafx.beans.Observable;
=======
import View.ViewUtilities.ImageAssets;
import javafx.beans.Observable;
>>>>>>> 0a99fe5f291bbd1056eed9491699d263ce2cb45d

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
public class InventoryView extends JPanel implements Observer{

    private Inventory inventory;
    //private ArrayList<Item> inventoryList;
    //private Armor equippedArmor;
    //private Weapon equippedWeapon;
    private HashMap<Item, BufferedImage> itemViewMap;
    private ArrayList<BufferedImage> itemViewList;

    private int xSel, ySel, xMax, yMax;
    private boolean armorSel;
    private boolean weaponSel;
    //private BufferedImage slotImage;
    private BufferedImage weaponImage;
    private BufferedImage armorImage;

    private int xBorderOffset, yBorderOffset, squareSize, xSize, ySize;


    public InventoryView(ActiveGameState gameState){
        inventory = gameState.getAvatar().getInventory();
        //add items with respective image to itemViewMap

        ySel = 0;
        xSel = 0;
        xMax = Settings.MAX_INVENTORY_SIZE/4;
        yMax = Settings.MAX_INVENTORY_SIZE/4;
        MessageHandler.println("InventoryView initialized", ErrorLevel.NOTICE, PersonFilter.SAM);
        xBorderOffset = Settings.GAMEWIDTH/8;
        yBorderOffset = Settings.GAMEHEIGHT/8;
        xSize = Settings.GAMEWIDTH*3/4;
        ySize = Settings.GAMEHEIGHT*3/4;
        squareSize = 100;
    }

    public void selectRight(){
        if (xSel < xMax-1) xSel++;
        else if (ySel<2) armorSel = true;
        else weaponSel = true;
    }

    public void selectLeft(){
        if (armorSel || weaponSel ){
            weaponSel = false;
            armorSel = false;
        }
        else if (xSel>0) xSel--; }

    public void selectUp(){
        if (weaponSel) {
            weaponSel = false;
            armorSel = true;
        }
        else if (ySel>0) ySel--; }

    public void selectDown(){
        if (armorSel) {
            armorSel = false;
            weaponSel = true;
        }
        if (ySel< yMax-1) ySel++; }

    public void interactWithItem(){ //MAKE SURE INVENTORY HANDLES ERROR CHECKING IF TRYING TO USE AN ITEMSLOT THAT ISN'T FILLED!!!
        //y*4+x
        //inventory.
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        Color myColour = new Color(49, 17, 7, 220);
        g2d.setColor(myColour);

        g2d.fillRect(xBorderOffset,yBorderOffset,xSize, ySize);
        float opacity = 0.7f; //make pictures opaque
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity)); //make pictures opaque
        for(int y=0;y<yMax;y++){ //draw all squares
            for (int x=0; x<xMax; x++){
                g2d.drawImage(ImageAssets.invSlot, xBorderOffset+50+x*squareSize,yBorderOffset+75+y*squareSize, squareSize,squareSize, null);
            }
        }
        //draw armor and weapon slot
        g2d.drawImage(ImageAssets.eqSlot, xBorderOffset +xSize/2 + squareSize, Settings.GAMEHEIGHT/2-2*squareSize,squareSize*2,squareSize*2, null);
        g2d.drawImage(ImageAssets.eqSlot, xBorderOffset +xSize/2 + squareSize, Settings.GAMEHEIGHT/2, squareSize*2,squareSize*2, null);

        //get rid of opaqueness
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(new Color(166, 0, 4, 255));
        g2d.setFont(new Font("Courier New", 1, 48));
        g2d.drawString("Inventory "+xSel+","+ySel +" Equipment", xBorderOffset+squareSize, yBorderOffset+50);

        //highlight selection
        if (armorSel){
            g2d.drawImage(ImageAssets.select, xBorderOffset +xSize/2 + squareSize, Settings.GAMEHEIGHT/2-2*squareSize,squareSize*2,squareSize*2, null);
        } else if(weaponSel){
            g2d.drawImage(ImageAssets.select, xBorderOffset +xSize/2 + squareSize, Settings.GAMEHEIGHT/2, squareSize*2,squareSize*2, null);
        } else g2d.drawImage(ImageAssets.select, xBorderOffset+50+xSel*squareSize, yBorderOffset+75+ySel*squareSize,squareSize,squareSize,null);

        g2d.dispose();
    }


    @Override
    public void update() {
        //inventory.
        //this.inventoryList =  inventory.getPack().getItems(); // TODO: Fix the LOD VIOLATION!!! (Is there a fix?)
        //this.equippedArmor = inventory.getEquipment().getArmor();
        //this.equippedWeapon = inventory.getEquipment().getWeapon();
    }

    @Override
    public void remove() {

    }
}
