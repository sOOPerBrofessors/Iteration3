package View.MapView;

import Model.Entity.Character.Character;
import Model.Map.Location;
import Model.Map.TileColumn;
import Utilities.Settings;
import Utilities.Visitor.ColumnVisitor;
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
public class TileColumnView extends JComponent implements TileVisitor, ColumnVisitor {
    ArrayList<TileView> listOfTiles;
    ArrayList<MapObjectView> listOfMapObjects; //This is a container of all the objects that might reside in that slot

    private int x;
    private int y;
    private int xPixel;
    private int yPixel;
    private int xOffset;
    private int yOffset;
    private int tileWidth = Settings.TILEWIDTH;
    private int tileHeight = Settings.TILEHEIGHT;
    private int xCenter = tileWidth/2;
    private int yCenter = tileHeight/2;
    private TileColumn tileColumn;
    public TileColumnView(TileColumn subject, Location location){
        xOffset = 0;
        yOffset = 0;
        x = location.getX();
        y = location.getY();
        listOfTiles = new ArrayList<>();
        listOfMapObjects = new ArrayList<>();
        updateCoordinateToScreenPosition();
        tileColumn = subject;
        updateTileViews(); //This needs to be called to get all the correct tiles.
        updateMapObjectViews(); //Called to update the map objects that are on top of the column
    }
    //Function basically copies the list  with its tile column subject
    private void updateTileViews(){
        for (int k = 0; k < tileColumn.getTopPosition(); k++){ //Top position represents all tiles that are not air

            //Basically it adds a tileview and the tile view is getting its value from tilecolumn view
            TileView tmpTileView = tileColumn.getTileList().get(k).acceptTileVisitor(this);
            addTileView(tmpTileView);
        }
    }
    private void updateMapObjectViews(){
        listOfMapObjects.clear(); //This will empty the list of items currently on the tileColumn

        //Checks and adds the whole list of objects at the end hopefully on the top
        addMapObjects( tileColumn.acceptMapVisitor(this) );
    }

    @Override
    public TileView createWaterTile() {
        return new WaterTileView();
    }

    @Override
    public TileView createGrassTile() {
        return new GrassTileView();
    }

    @Override
    public TileView createRiverTile() {
        return new RiverTileView();
    }
    //Air tile is nothing at the moment; (might possibly be other stuff in the future
    @Override
    public TileView createAirTile() {
        return null;
    }

    public void addTileView (TileView tileView){
        if (listOfTiles.size() < 10) {
            listOfTiles.add(tileView);
        }
    }
    public void addMapObjectView(MapObjectView mapObjectView){
        listOfMapObjects.add(mapObjectView);
    }

    public void addMapObjects(ArrayList<MapObjectView> objects) {
        for (MapObjectView mapObjectView : objects){
            addMapObjectView(mapObjectView);
        }
    }

    private void updateCoordinateToScreenPosition(){
        xPixel = x*tileWidth - (x*(tileWidth))/4 + xOffset;
        yPixel = y*(tileHeight - 5) + ((tileHeight-7)*x)/2 + yOffset;

     //   System.out.println("TileColumnView: X/Y: " + x + "," + y + " : " + xPixel + "," + yPixel);
    }
    //Function to paint everything
    public void paintComponent(Graphics g){
        //First make sure that you are up to date on the position
        updateCoordinateToScreenPosition();

        //Paint the tileColumns
        paintTileColumn(g);

        paintMapObjects(g);
    }
    private void paintTileColumn(Graphics g){
        for (int i = 0; i < listOfTiles.size(); i++){
            //In setPixels, the 3rd arguement is essentially the "z" height
            TileView holder = listOfTiles.get(i);
            holder.setLocation(x,y,i); //"i" is considered z in this case

            //The tile view should not have the centers added to it
            holder.setPixels(xPixel, yPixel, i);
            holder.paintComponent(g);
        }
    }

    private void paintMapObjects(Graphics g){
        //TODO: Might be temporary for now since i'll want to update the map objects upon click and not every time
        //Paint is called
        updateMapObjectViews();
        int centeredX = xPixel + xCenter/2;
        int centeredY = yPixel - yCenter;
        for (int i = 0; i < listOfMapObjects.size(); i++){
            //The last value of the list of tiles should be the last height where to render for Z
            listOfMapObjects.get(i).setPixels(centeredX,centeredY,listOfTiles.size());
            listOfMapObjects.get(i).paintComponent(g);
        }
    }
    //Updates the camera view
    public void offsetCamera(Location offset){
            //updateCoordinateToScreenPosition();
            xOffset = offset.getX();
            yOffset = offset.getY();
    }

    @Override
    public CharacterView createCharacterView(Character character) {
        return new CharacterView(character);
    }
}
