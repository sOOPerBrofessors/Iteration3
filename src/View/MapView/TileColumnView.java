package View.MapView;

import Model.Map.Location;
import Utilities.Settings;
import View.AreaViewport.FogOfWar.NonVisibleState;
import View.AreaViewport.FogOfWar.ShroudedState;
import View.AreaViewport.FogOfWar.TileViewState;
import View.AreaViewport.FogOfWar.VisibleState;
import View.ItemView.ItemView;
import View.TerrainView.*;



import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dyeung on 4/8/16.
 */
//Purpose of this class is to emulate and (?)observer the tile slot within map
    // The observing might not be necessary as everything else is observing the other mapobjects
public class TileColumnView extends JComponent {

    ArrayList<TileView> listOfTiles;
    private int x;
    private int y;
    private int xPixel;
    private int yPixel;
    private int xCameraOffset;
    private int yCameraOffset;
    private int tileWidth = Settings.TILEWIDTH;
    private int tileHeight = Settings.TILEHEIGHT;
    private int xCenter = tileWidth/2;
    private int yCenter = tileHeight/2;
    private TileViewState tileViewState;
    public TileColumnView(ArrayList<TileView> subject, Location location){
        xCameraOffset = 0;
        yCameraOffset = 0;
        x = location.getX();
        y = location.getY();
        listOfTiles = subject;
        updateCoordinateToScreenPosition();
        tileViewState = new ShroudedState();
    }

    private void updateCoordinateToScreenPosition(){
        xPixel = x*tileWidth - (x*(tileWidth))/4 + xCameraOffset;
        yPixel = y*(tileHeight - 5) + ((tileHeight-7)*x)/2 + yCameraOffset;
    }

    public void paintComponent(Graphics g){
        //First make sure that you are up to date on the position
        updateCoordinateToScreenPosition();

        //Paint the tileColumns

        paintTileColumn(g);
    }

    private void paintTileColumn(Graphics g) {
        tileViewState.drawState(this, g);
    }
    //Updates the camera view

    public void offsetCamera(Location offset){
            //updateCoordinateToScreenPosition();
            xCameraOffset = offset.getX();
            yCameraOffset = offset.getY();
    }

    public void paintShrouded(Graphics g){
        //Paint empty tile
    }

    public void paintVisible(Graphics g){
        // add item to tile

        for (int i = 0; i < listOfTiles.size(); i++) {
            //In setPixels, the 3rd arguement is essentially the "z" height
            TileView holder = listOfTiles.get(i);

            //The tile Y pixels should be increased based on the z coordinate per column
            yPixel -= 8; //Now this will be the same as paintMapObjects
            holder.setPixels(xPixel, yPixel);
            holder.paintComponent(g);
        }
    }

    public void paintNonVisible(Graphics g){
        //Using overlay or making it just different color?
        //paint seen but not visible tile
        // Set the opacity.

        float MIN_OPACITY = 0.4f; // The min opacity for a visible tile
        Graphics2D g2 = (Graphics2D) g.create();
        float opacity = 1.0f - (1 - MIN_OPACITY);
        AlphaComposite acomp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity);
        g2.setComposite(acomp);
        paintVisible(g2); //for now just paint visible
    }

    public void setVisibleState(){
        tileViewState = new VisibleState();
    }
    public void setNonVisibleState(){
        tileViewState = new NonVisibleState();
    }
    //This isn't going to work now that we have air tiles. What if I drop an item while a bird is above my head?
    public void setItemView(ItemView itemView){
        listOfTiles.get(listOfTiles.size() - 1).addItemView(itemView);
    }
    public void clearItemView(){
        listOfTiles.get(listOfTiles.size() - 1).removeItemView();
    }

}