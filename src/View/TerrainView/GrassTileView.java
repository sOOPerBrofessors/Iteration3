package View.TerrainView;

import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.Settings;
import Utilities.SpriteImageFactory;
import View.AreaViewport.CameraView;
import View.EntityView.EntityView;
import View.ItemView.ItemView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dyeung on 4/5/16.
 */
public class GrassTileView extends TileView{
    private String url = "./res/terrain/grass.png";

    private ArrayList<ItemView> itemViewArrayList;
    public GrassTileView(Tile tile){
        super(tile);
        image = SpriteImageFactory.getImage(url);
        itemViewArrayList = new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + location.getX() + "," + location.getY());

        g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
//        g.setColor(Color.GREEN);
//        g.drawRect(xPixel,yPixel,tileWidth,tileHeight);

        String debug = location.getX() + "," + location.getY();
        Font f = new Font("Courier New", 1, 12);
        g.setFont(f);
        g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));

        renderEntity(g);
    }

}


