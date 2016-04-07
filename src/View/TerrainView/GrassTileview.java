package View.TerrainView;

import Model.Map.Location;
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
public class GrassTileview extends JComponent{
    private String url = "./res/terrain/grass.png";
    private Image grassImage;
    private Location location;

    private int tileWidth = Settings.TILEWIDTH;
    private int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map

    //Might be needed later ( should the tile know what to put ontop of itself)
    private EntityView entityView;
    public GrassTileview(Location location){
        this.location = location;
        grassImage = SpriteImageFactory.getImage(url);
        updateCoordinateToScreenPosition();
    }
    //Function to offset the x and y coordinates based off of the (x,y) positions
    public void updateCoordinateToScreenPosition(){
        int x = location.getX();
        int y = location.getY();
        xPixel = x*tileWidth - (x*tileWidth)/4;
        yPixel = y*tileHeight + (tileHeight*x)/2;
    }

    public void updateCameraOffset(Location location){
        updateCoordinateToScreenPosition();
        xPixel += location.getX();
        yPixel += location.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + xPosition + "," + yPosition);
        for (int i = 0; i < location.getZ(); i++) {
            g.drawImage(grassImage,xPixel,yPixel,tileWidth,tileHeight,null);
            String debug = xPixel + "," + yPixel;
            Font f = new Font("Courier New", 1, 12);
            g.setFont(f);
            g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));
        }
    }

}


