package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Character.Mount.Mount;
import Model.Entity.Entity;
import Model.Entity.Projectile.Projectile;
import Model.Map.Tile.*;
import Utilities.Visitor.*;

import java.util.ArrayList;

/**
 * Created by dyeung on 4/6/16.
 */
public class TileColumn implements TileVisitable, TerrainVisitable{

    ArrayList<Tile> tileList;
    //WATER IS ALWAYS ABOVE GROUND IN THIS ITERATION (So it goes from topGround -> checks topWater -> top tile not air
    private int topGroundTile;
    private int topWater; //Maybe necessary?
    private int topTileNotAir;

    public TileColumn(){
        topGroundTile = 0;
        topWater = 0;
        topTileNotAir = 0;
        tileList = new ArrayList<>();
    }
    public void addWaterTile(Tile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
            topWater++;
            topTileNotAir++;
        }
    }
    public void addAirTile(Tile tile){
        tileList.add(tile);
    }
    public void addGrassTile(Tile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
            topGroundTile++;
            topTileNotAir++;
        }
    }
    public void addRiverTile(Tile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
            topWater++;
            topTileNotAir++;
        }
    }
    public void addDirtTile(Tile tile){
        if (tileList.size() < 10) {
            tileList.add(tile);
            topTileNotAir++;
            topGroundTile++;
        }
    }

    public Tile getTopTile(){
        return tileList.get(topTileNotAir - 1);
    }
    public Tile getTileAt(int i){
        if (tileList.size() < 10)
            return null;
        return tileList.get(i);
    }
    public int getTopPosition(){
        return topTileNotAir - 1;
    }

    public int getMaxSize() {
        return tileList.size();
    }


    //For loading
    public void addCharacter(Character character){
        int z = character.getLocation().getZ();
        tileList.get(z).addCharacter(character);
    }

    public void addMount(Mount mount){
        int z = mount.getZ();
        tileList.get(z).addMount(mount);
    }

    public void removeCharacter(Character character){
        int z = character.getZ();
        tileList.get(z).removeCharacter();
    }

    // all about them projectiles bro
    public void addProjectile(Projectile projectile){
        int z = projectile.getLocation().getZ();
        tileList.get(z).addProjectile(projectile);

    }

    @Override
    public void acceptTerrainVisitor(TerrainVisitor tv) {
        for(Tile tile : tileList){
            tile.acceptTerrainVisitor(tv);
        }
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
        for(Tile tile : tileList){
            tile.acceptTileVisitor(tv);
        }
    }
}