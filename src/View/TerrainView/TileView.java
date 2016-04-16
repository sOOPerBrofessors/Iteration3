package View.TerrainView;

import Model.Entity.Character.Avatar;
import Model.Entity.Character.NPC.NPC;
import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.Observers.TileObserver;
import Utilities.Settings;
import Utilities.Visitor.EntityViewVisitor;
import View.EntityView.CharacterView;
import View.EntityView.EntityView;
import View.ItemView.ItemView;
import View.MapView.MapObjectView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by dyeung on 4/7/16.
 */
public abstract class TileView extends JComponent implements EntityViewVisitor, TileObserver {

    protected Location location;
    protected int tileWidth = Settings.TILEWIDTH;
    protected int tileHeight = Settings.TILEHEIGHT;
    protected int xPixel; // on the map
    protected int yPixel; // on the map
    protected Image image;
    private EntityView entityView;
    private Tile tile;
    private ItemView itemView;

    public TileView(Tile tile){
        this.tile = tile;
        updateTileView();
        tile.acceptTileObserver(this);
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
    }

    public void setLocation(int x, int y, int z){
        location = new Location(x,y,z);
    }

    public abstract void paintComponent(Graphics g);

    protected boolean hasEntity(){
        if (entityView == null) {
            return false;
        }else {
            return true;
        }
    }

    protected boolean hasItem(){
        if (itemView == null) {
            return false;
        }else {
            return true;
        }
    }

    //TODO: change this so it just renders map object views
    public void renderEntity(Graphics2D g){
        if (hasEntity()){
            //System.out.println(location.getX() + "," +location.getY() +"," +location.getZ());
            int centeredX = xPixel + Settings.TILEWIDTH/4;
            int centeredY = yPixel - Settings.TILEHEIGHT/2;
            entityView.setPixels(centeredX, centeredY);
            entityView.paintComponent(g);
        }
    }

    public void renderItem(Graphics2D g){
        if(hasItem()) {
            int centeredX = xPixel + Settings.TILEWIDTH/4;
            int centeredY = yPixel - Settings.TILEHEIGHT/2;
            itemView.setPixels(centeredX, centeredY);
            itemView.paintComponent(g);
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
}