package View.InventoryView;

import Model.Entity.Character.Avatar;
import Model.Inventory.Inventory;
import Model.Items.Item;
import Model.State.GameState.ActiveGameState;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.Observers.Observer;
import Utilities.PersonFilter;
import Utilities.Settings;
import View.ItemView.ItemView;
import View.ViewUtilities.Sprites.ImageAssets;
import sun.plugin2.message.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by sgl on 4/9/16.
 */

//Displays Inventory in 4x4 matrix. x goes to the right, y goes down
public class InventoryView extends JPanel implements Observer{

    private Inventory inventory; //handle to Avatar's inventory
    ArrayList<Item> items; //handle to Avatar's ArrayList of Items
    Image[] invImages = new Image[16]; //Local Array of Images of Inventory
    //private Armor equippedArmor;
    //private Weapon equippedWeapon;
    private HashMap<Item, ItemView> itemViewHashMap;

    private int xSel, ySel, xMax, yMax;
    private boolean armorSel;
    private boolean weaponSel;
    //private BufferedImage slotImage;
    private BufferedImage weaponImage;
    private BufferedImage armorImage;

    private int xBorderOffset, yBorderOffset, squareSize, xSize, ySize;


    public InventoryView(ActiveGameState gameState){
        Avatar avatar = gameState.getAvatar(); //LOD
        inventory = avatar.getInventory();       //LOD
        items = inventory.getPack().getItems();
        itemViewHashMap = gameState.getItemManager().getAllItemViews();  //LOD, add items with respective image to itemViewMap
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
                g2d.drawImage(ImageAssets.invSlot, xBorderOffset+50+x*squareSize,yBorderOffset+75+y*squareSize, squareSize,squareSize, null); //draw InvSlot
                int currentSlot = y*4+x;
                if (currentSlot< items.size()) //for performance (Don't actually know if would increase performance)
                    g2d.drawImage(invImages[currentSlot],xBorderOffset+50+x*squareSize,yBorderOffset+75+y*squareSize, squareSize,squareSize, null);
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
        items = inventory.getPack().getItems();
        MessageHandler.println("Inventory size: " + Integer.toString(items.size()), ErrorLevel.NOTICE, PersonFilter.SAM);
        for (int i = 0; i<items.size(); i++){
                MessageHandler.println("Adding Image to Inventory: " + Integer.toString(i), ErrorLevel.NOTICE, PersonFilter.SAM);
                try {
                    invImages[i] = itemViewHashMap.get(items.get(i)).getImage();
                } catch (NullPointerException e){
                    e.printStackTrace();
                    MessageHandler.println("Adding Image to Inventory ERROR: " + Integer.toString(i), ErrorLevel.CRITICAL, PersonFilter.SAM);
                }


        }

    }

    @Override
    public void remove() {

    }
}
