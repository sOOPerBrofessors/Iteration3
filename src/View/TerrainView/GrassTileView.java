package View.TerrainView;

import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.Settings;
import Utilities.SpriteImageFactory;
import View.AreaViewport.CameraView;
import View.EntityView.EntityView;

import javax.swing.*;
import java.awt.*;
import java.util.Set;

/**
 * Created by dyeung on 4/5/16.
 */
public class GrassTileView extends TileView{
    private String url = "./res/terrain/grass_flat.png";



    //Might be needed later ( should the tile know what to put ontop of itself)
    //private EntityView entityView;
    public GrassTileView(Location location){
        super(location);
        image = SpriteImageFactory.getImage(url);
    }


    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + location.getX() + "," + location.getY());
        g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
        String debug = location.getX() + "," + location.getY();
        Font f = new Font("Courier New", 1, 12);
        g.setFont(f);
        g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));
    }

}


