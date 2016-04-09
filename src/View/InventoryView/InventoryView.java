package View.InventoryView;

import Model.Inventory.Inventory;
import Utilities.Settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sgl on 4/9/16.
 */

//Displays Inventory in 4x4 matrix. x goes to the right, y goes down
public class InventoryView extends JComponent {
    private Inventory inventory;
    private int xSel, ySel, xMax, yMax;


    public InventoryView(Inventory inventory){
        this.inventory = inventory;
        xSel = 0;
        ySel = 0;
        xMax = Settings.MAX_INVENTORY_SIZE/4;
        yMax = Settings.MAX_INVENTORY_SIZE/4;
    }

    public void selectRight(){ if (xSel < 4) xSel++; }

    public void selectLeft(){ if (xSel>0) xSel--; }

    public void selectUp(){ if (ySel>0) ySel--; }

    public void selectDown(){ if (ySel<4) ySel++; }

    public void interactWithItem(){
        //y*4+x
        //inventory.
    }

    @Override
    protected void paintComponent(Graphics g) {

    }


}
