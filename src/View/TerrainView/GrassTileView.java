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
    private String url = "./res/terrain/grass.png";
    private Image grassImage;

    private int tileWidth = Settings.TILEWIDTH;
    private int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map

    //Might be needed later ( should the tile know what to put ontop of itself)
    //private EntityView entityView;
    public GrassTileView(Location location){
        super(location);
        grassImage = SpriteImageFactory.getImage(url);
        updateCoordinateToScreenPosition();
    }
    //Function to offset the x and y coordinates based off of the (x,y) positions
    public void updateCoordinateToScreenPosition(){
        int x = location.getX();
        int y = location.getY();
        int xCenter = tileWidth/2;
        int yCenter = tileHeight/2;
        xPixel = xCenter + x*tileWidth - (x*(tileWidth-5))/4;
        //yPixel = y*tileHeight + (tileHeight*x)/2;
        yPixel = yCenter + y*(tileHeight - 7) + ((tileHeight-12)*x)/2;

    }
    @Override
    public void updateCameraOffset(Location location){
        updateCoordinateToScreenPosition();
        xPixel += location.getX();
        yPixel += location.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + location.getX() + "," + location.getY());
        g.drawImage(grassImage,xPixel,yPixel,tileWidth,tileHeight,null);
        String debug = location.getX() + "," + location.getY();
        Font f = new Font("Courier New", 1, 12);
        g.setFont(f);
        g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));
    }

}


