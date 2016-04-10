package Model.Map.Tile;

import Model.Entity.Entity;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
import Utilities.Visitor.TileVisitor;


/**
 * Created by sgl on 4/5/16.
 */

//DirtTile is just tells Nav that the Tile could not be travelled by. (doesn't hold a handle of entity)
public class DirtTile extends Tile {

    public DirtTile(){
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
        tv.createDirtTile(this);
    }

    @Override
    public Entity getEntity() {
        //System.out.println("DirtTile: Error: you are trying to get an entity of a tile");
        return null;
    }

    @Override
    public boolean hasEntity() {
        return false;
    }

    @Override
    public void removeEntity() {
        MessageHandler.println("DirtTile: you shoulnd't be removing entities", ErrorLevel.ERROR, PersonFilter.DAVID);
    }

    @Override
    public void addEntity(Entity entity) {
        MessageHandler.println("Dirt tile: you shouldn't be adding entities in here", ErrorLevel.ERROR, PersonFilter.DAVID);
    }
}
