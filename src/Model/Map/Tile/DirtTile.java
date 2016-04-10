package Model.Map.Tile;

import Model.Entity.Entity;
import Model.Map.Location;
import Utilities.MessageHandler;
import Utilities.Visitor.EntityVisitor;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;


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
        MessageHandler.printError("Dirt Tile: Do nothing");
    }

    @Override
    public void addEntity(Entity entity) {
        MessageHandler.printError("dirt tile: you shouldn't be adding entities in here");
    }
}
