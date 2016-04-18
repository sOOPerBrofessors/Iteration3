package View.MenuViews;

import Model.Entity.Character.Avatar;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.Items.Takeable.TakeableItem;
import Model.State.GameState.ActiveGameState;
import Utilities.ErrorLevel;
import Utilities.ItemStuff.ItemManager;
import Utilities.MessageHandler;
import Utilities.Observers.Observer;
import Utilities.PersonFilter;
import Utilities.Settings;
import View.ItemView.ItemView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by sgl on 4/9/16.
 */

//Displays Inventory in 4x4 matrix. x goes to the right, y goes down
    //armor on top of weapon for equipment view
public class InventoryView extends AllDirPanel implements Observer{

    private Avatar avatar;
    private Inventory inventory; //handle to Avatar's inventory
    ArrayList<TakeableItem> items; //handle to Avatar's ArrayList of Items
    Image[] invImages = new Image[16]; //Local Array of Images of Inventory
    //private Armor equippedArmor;
    //private Weapon equippedWeapon;
    private ItemManager itemManager;
    private HashMap<Item, ItemView> itemViewHashMap;

    private int xSel, ySel, xMax, yMax;
    private boolean armorSel;
    private boolean weaponSel;
    private Image weaponImage;
    private Image armorImage;
    private int squareSize;
    private final int yShift = 50;


    public InventoryView(ActiveGameState gameState){
        this.avatar = gameState.getAvatar(); //LOD
        inventory = avatar.getInventory();       //LOD
        items = inventory.getPack().getItems();
        itemManager = gameState.getItemManager();
        itemViewHashMap = itemManager.getAllItemViews();  //LOD, add items with respective image to itemViewMap
        ySel = 0;
        xSel = 0;
        xMax = Settings.MAX_INVENTORY_SIZE/4;
        yMax = Settings.MAX_INVENTORY_SIZE/4;
        squareSize = 100;
        avatar.addObserver(this);
        update();
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
        else if (xSel>0) xSel--;
    }

    public void selectUp(){
        if (weaponSel) {
            weaponSel = false;
            armorSel = true;
        }
        else if (ySel>0) ySel--;
    }

    public void selectDown(){
        if (armorSel) {
            armorSel = false;
            weaponSel = true;
        }
        if (ySel< yMax-1) ySel++;
    }

    public void select(){ //MAKE SURE INVENTORY HANDLES ERROR CHECKING IF TRYING TO USE AN ITEMSLOT THAT ISN'T FILLED!!!
        if (armorSel){
            avatar.unEquipArmor();
        } else if (weaponSel){
            avatar.unEquipWeapon();
        } else if (calcSel() < items.size()){
            avatar.utilizeItem(calcSel());
        }
    }
    public void dropItem(){
        if (calcSel() < items.size())
            itemManager.addItem(inventory.dropItem(calcSel()),avatar);
    }

    private int calcSel(){
        return ySel*4+xSel;
    }

    private void debug(String string){
        MessageHandler.println(string,ErrorLevel.NOTICE, PersonFilter.SAM);
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        drawBackground(g2d);
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); //make pictures opaque
        for(int y=0;y<yMax;y++){ //draw all squares
            for (int x=0; x<xMax; x++){
                g2d.drawImage(ImageAssets.invSlot, xBorderOffset+50+x*squareSize,yBorderOffset+75+y*squareSize+yShift/2, squareSize,squareSize, null); //draw InvSlot
                int currentSlot = y*4+x;
                if (currentSlot< items.size()) {//for performance (Don't actually know if would increase performance)
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); //make pictures solid
                    g2d.drawImage(invImages[currentSlot], xBorderOffset + 75 + x * squareSize, yBorderOffset + 100 + y * squareSize+yShift/2, squareSize/2, squareSize/2, null);
                    g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f)); //make pictures opaque
                }
            }
        }
        //draw armor and weapon slot
        g2d.drawImage(ImageAssets.eqSlot, xBorderOffset +xSize/2 + squareSize+10, Settings.GAMEHEIGHT/2-2*squareSize+yShift*3/2,squareSize*2,squareSize*2, null);
        g2d.drawImage(ImageAssets.eqSlot, xBorderOffset +xSize/2 + squareSize+10, Settings.GAMEHEIGHT/2+yShift*3/2, squareSize*2,squareSize*2, null);
        //draw armor and weapon
        g2d.drawImage(armorImage, (xBorderOffset +xSize/2 + squareSize*3/2+10)*Settings.SCALEFACTOR, (Settings.GAMEHEIGHT/2-2*squareSize+yShift*5/2)*Settings.SCALEFACTOR,squareSize,squareSize, null);
        g2d.drawImage(weaponImage, (xBorderOffset +xSize/2 + squareSize*3/2+10)*Settings.SCALEFACTOR, (Settings.GAMEHEIGHT/2+yShift*5/2)*Settings.SCALEFACTOR, squareSize,squareSize, null);


        //get rid of opaqueness
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setColor(new Color(166, 0, 4, 255));

        g2d.setFont(new Font(Font.MONOSPACED, 1, 36));
        String invyString = "Inventory",
                equipString = "Equipment";
        int invyWidth = g2d.getFontMetrics().stringWidth(invyString);
        int equipWidth = g2d.getFontMetrics().stringWidth(equipString);
        g2d.drawString(invyString, xBorderOffset+(squareSize+25)*2 - invyWidth/2, yBorderOffset+70);
        g2d.drawString(equipString, Settings.GAMEWIDTH - xBorderOffset - squareSize+5 - equipWidth, yBorderOffset+70);

        //highlight selection
        if (armorSel){
            g2d.drawImage(ImageAssets.select, xBorderOffset +xSize/2 + squareSize+10, Settings.GAMEHEIGHT/2-2*squareSize+yShift*3/2,squareSize*2,squareSize*2, null);
        } else if(weaponSel){
            g2d.drawImage(ImageAssets.select, xBorderOffset +xSize/2 + squareSize+10, Settings.GAMEHEIGHT/2+yShift*3/2, squareSize*2,squareSize*2, null);
        } else g2d.drawImage(ImageAssets.select, xBorderOffset+50+xSel*squareSize, yBorderOffset+75+ySel*squareSize+yShift/2,squareSize,squareSize,null);

        g2d.dispose();
    }


    @Override
    public void update() {
        //MessageHandler.println("UPDATE called", ErrorLevel.NOTICE, PersonFilter.SAM);
        for (int i = 0; i<items.size(); i++){
                //MessageHandler.println("Adding Image to Inventory: " + Integer.toString(i), ErrorLevel.NOTICE, PersonFilter.SAM);
                try {
                    invImages[i] = itemViewHashMap.get(items.get(i)).getImage();
                } catch (NullPointerException e){
                    e.printStackTrace();
                    //MessageHandler.println("Adding Image to Inventory ERROR: " + Integer.toString(i), ErrorLevel.CRITICAL, PersonFilter.SAM);
                }
        }
        weaponImage = armorImage = null; //reset images so that they don't retain old images if unequipped shit
        if (inventory.getWeapon()!=null) {
            weaponImage = itemViewHashMap.get(inventory.getWeapon()).getImage();
            //MessageHandler.println("WeaponUpdate: "+inventory.getWeapon().getName(),ErrorLevel.NOTICE,PersonFilter.SAM);
        }
        if (inventory.getArmor()!=null) {
            armorImage = itemViewHashMap.get(inventory.getArmor()).getImage();
            //MessageHandler.println("ArmorUpdate: "+inventory.getArmor().getName(),ErrorLevel.NOTICE,PersonFilter.SAM);
        }
    }

    @Override
    public void remove() {}
}
