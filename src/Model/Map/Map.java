package Model.Map;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Map.Tile.Tile;

/**
 * Created by sgl on 4/5/16.
 */
public class Map {
    private int maxRow;
    private int maxColumn;
    public Map(TileColumn[][] tiles){
        mapOfTiles = tiles;
        maxRow = tiles.length;
        maxColumn = tiles[0].length;
    }
    private TileColumn[][] mapOfTiles;

    //For loading -- might need some version of design pattern to get rid of this
    public TileColumn[][] getMapOfTiles(){
        return mapOfTiles;
    }

    public Tile getTopTile(int x, int y) {
        //TODO: Needs some better checks for height difference
        //might be more helpful to add more defining functions withing 'TileColumn' to check for height
        if (x < 0 || y < 0 || x > maxColumn || y > maxRow) {
            return null;
        }else {
            return mapOfTiles[x][y].getTopTile();
        }
    } // end getTile


    //FOR LOADING
    //Entities include projectile things that could be anywhere on 3d axis
    public void addEntity(Entity entity){
        mapOfTiles[entity.getX()][entity.getY()].addEntity(entity);
    }
    //Characters are essentially things that exist on the top of group types
    public void addCharacter(Character character){
        mapOfTiles[character.getX()][character.getY()].addCharacter(character);
    }
    public void removeEntity(Entity entity){
        mapOfTiles[entity.getX()][entity.getY()].removeEntity(entity);
    }
}
