package View.MapView;

import Model.Entity.Character.Avatar;
import Model.Entity.Entity;
import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Model.Map.TileColumn;
import Utilities.Settings;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.*;
import Utilities.Visitor.TileVisitor;
import View.EntityView.CharacterView;
import View.TerrainView.GrassTileView;
import View.TerrainView.RiverTileView;
import View.TerrainView.TileView;
import View.TerrainView.WaterTileView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dyeung on 4/8/16.
 */
//Purpose of this class is to emulate and (?)observer the tile slot within map
    // The observing might not be necessary as everything else is observing the other mapobjects
public class TileColumnView extends JComponent implements TileVisitor {
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
    private TileColumn tileColumn;
    public TileColumnView(TileColumn subject, Location location){
        xCameraOffset = 0;
        yCameraOffset = 0;
        x = location.getX();
        y = location.getY();
        listOfTiles = new ArrayList<>();
        updateCoordinateToScreenPosition();
        tileColumn = subject;
        updateTileViews(); //This needs to be called to get all the correct tiles.
    }
    //Function basically copies the list  with its tile column subject
    private void updateTileViews(){
        //Top position represent the top tile that is not an air tile
        for (int k = 0; k < tileColumn.getTopPosition(); k++){
            tileColumn.getTileList().get(k).acceptTileVisitor(this);
        }
    }

    @Override
    public void createWaterTile(Tile tile) {
         addTileView(new WaterTileView(tile));
    }

    @Override
    public void createGrassTile(Tile tile) {
        addTileView(new GrassTileView(tile));
    }

    @Override
    public void createRiverTile(Tile tile) {
        addTileView(new RiverTileView(tile));
    }

    //Air tile is nothing at the moment; (might possibly be other stuff in the future
    @Override
    public void createAirTile(Tile tile) {
        addTileView(new AirTileView(tile));
    }

    @Override
    public void createDirtTile(Tile tile) {
        addTileView(new DirtTileView(tile));
    }

    protected void addTileView (TileView tileView){
        tileView.setLocation(x,y,listOfTiles.size());
        if (listOfTiles.size() < 10) {
            listOfTiles.add(tileView);
        }
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
    //TODO this will eventually paint all the coloumns because of entites on air
    private void paintTileColumn(Graphics g){
        for (int i = 0; i < listOfTiles.size(); i++){
            //In setPixels, the 3rd arguement is essentially the "z" height
            TileView holder = listOfTiles.get(i);

            //The tile Y pixels should be increased based on the z coordinate per column
            yPixel -= 8; //Now this will be the same as paintMapObjects
            holder.setPixels(xPixel, yPixel);
            holder.paintComponent(g);

            paintMapObjects(holder,g); //paints the tileview
        }
    }

    private void paintMapObjects(TileView tileView, Graphics g){
        tileView.renderEntity(g);
    }
    //Updates the camera view
    public void offsetCamera(Location offset){
            //updateCoordinateToScreenPosition();
            xCameraOffset = offset.getX();
            yCameraOffset = offset.getY();
    }

}
