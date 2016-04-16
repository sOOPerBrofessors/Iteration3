package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Tile.*;
import Utilities.Visitor.TileVisitor;
import View.MapView.MapObjectView;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class TileColumn implements TileVisitor{

    ArrayList<Tile> tileList;

    private int topGroundTile;
    private int topWater; //Maybe necessary?
    private int topTileNotAir;

    public TileColumn(){
        topGroundTile = 0;
        topWater = 0;
        topTileNotAir = 0;
        tileList = new ArrayList<>();
    }

    @Override
    public void visitWaterTile(Tile tile) {
        tileList.add(tile);
        topWater++;
        topTileNotAir++;
    }

    @Override
    public void visitGrassTile(Tile tile) {
        tileList.add(tile);
        topGroundTile++;
        topTileNotAir++;
    }

    @Override
    public void visitAirTile(Tile tile) {
        tileList.add(tile);
    }

    @Override
    public void visitRiverTile(Tile tile) {
        tileList.add(tile);
        topTileNotAir++;
        topWater++;
    }

    @Override
    public void visitDirtTile(Tile tile) {
        tileList.add(tile);
        topTileNotAir++;
        topGroundTile++;
    }

    public ArrayList<Tile> getTileList(){
        return tileList;
    }

    public Tile getTopTile(){
        return tileList.get(topTileNotAir - 1);
    }
    public Tile getTileAt(int i){
        return tileList.get(i);
    }
    public int getTopPosition(){
        return topTileNotAir;
    }

    public int getMaxSize() {
        return tileList.size();
    }


    //For loading
    public void addEntity(Entity entity){
        int z = entity.getLocation().getZ();
        tileList.get(z).addEntity(entity);

    }
    public void addCharacter(Character character){
        getTopTile().addEntity(character);
    }
    public void removeEntity(Entity entity){
        int z = entity.getZ();
        tileList.get(z).removeEntity();
    }


}
