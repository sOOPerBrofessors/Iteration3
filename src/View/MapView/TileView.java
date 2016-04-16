package View.MapView;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.Observers.TileObserver;
import Utilities.Settings;
import Utilities.Visitor.EntityViewVisitor;
import Utilities.Visitor.TerrainVisitor;
import View.EntityView.CharacterView;
import View.EntityView.EntityView;
import View.TerrainView.*;
import View.ItemView.ItemView;


import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class TileView extends JComponent implements EntityViewVisitor, TileObserver, TerrainVisitor {

    protected Location location;
    protected int tileWidth = Settings.TILEWIDTH;
    protected int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Image image;
    private EntityView entityView;
    private Tile tile;
    private ItemView itemView;

    private TerrainView terrainView;
    public TileView(Tile tile, Location location){
        this.location = location;

        this.tile = tile;
        init();
        tile.acceptTileObserver(this);
    }
    private void init(){
        tile.getTerrain().acceptTerrainVisitor(this);
        updateTileView();
    }

    //TODO: make it so it just records the tile...this should not have to have
    protected void updateTileView(){
        if (tile.hasEntity()){
            tile.getEntity().acceptEntityVisitor(this);
        }else {
            removeEntityView();
        }
    }

     public void setPixels(int x, int y){
         xPixel = x;
         yPixel = y;
         terrainView.setXY(x,y);
    }

    public void setLocation(int x, int y, int z){
        location = new Location(x,y,z);
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g.create();

        renderTerrain(g2d);
        renderEntity(g2d);
        renderItem(g2d);
        g2d.dispose();
    }

    protected boolean hasEntity(){
        if (entityView == null) {
            return false;
        }else {
            return true;
        }
    }

    public void renderTerrain(Graphics g){
        terrainView.paintComponent(g);
        terrainView.renderDebug(g,location.getX(),location.getY());
    }


    protected boolean hasItem(){
        if (itemView == null) {
            return false;
        }else {
            return true;
        }
    }

    //TODO: change this so it just renders map object views
    public void renderEntity(Graphics g){
        if (hasEntity()){
            //System.out.println(location.getX() + "," +location.getY() +"," +location.getZ());
            int centeredX = xPixel + Settings.TILEWIDTH/4;
            int centeredY = yPixel - Settings.TILEHEIGHT/2;
            entityView.setPixels(centeredX, centeredY);
            entityView.paintComponent(g);
        }
    }

    public void renderItem(Graphics g){
        if(hasItem()) {
            itemView.setPixels(xPixel, yPixel);
            itemView.paintComponent((Graphics2D)g.create());
        }
    }

    @Override
    public void createAvatarView(Avatar avatar) {
        entityView = new CharacterView(avatar);
    }
    @Override
    public void createNPCView(NPC npc) {
        entityView = new CharacterView(npc);
    }

    @Override //This function is called when a tile is updated (for an example when a tile has a new entity)
    public void update() {
        //System.out.println("TileView: entity was moved");
        updateTileView();
    }

    private void removeEntityView(){
        if(entityView != null) {
            entityView.removeObservable();
            entityView = null;
        }
    }

    public void addItemView(ItemView itemView){
        this.itemView = itemView;

    }

    public void removeItemView(){
        itemView = null;
    }

    @Override
    public void visitWaterTerrain() {
        terrainView = new WaterTerrainView();
    }

    @Override
    public void visitGrassTerrain() {
        terrainView = new GrassTerrainView();
    }

    @Override
    public void visitAirTerrain() {
        terrainView = new AirTerrainView();
    }

    @Override
    public void visitRiverTerrain() {
        terrainView = new RiverTerrainView();
    }

    @Override
    public void visitDirtTerrain() {
        terrainView = new DirtTerrainView();
    }

}