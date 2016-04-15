package Model.Map.Tile;

import Model.Entity.Character.Character;
import Model.Entity.Entity;
import Model.Items.Item;
import Model.Map.AreaEffect.AreaOfEffect;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;
import Utilities.Visitor.TileVisitor;


/**
 * Created by sgl on 4/5/16.
 */

//DirtTile is just tells Nav that the Tile could not be travelled by. (doesn't hold a handle of entity)
public class DirtTile extends Tile {
    //I am going to get rid of this class and move it to the grass tile
    public DirtTile(){
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
        tv.visitDirtTile(this);
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
    public void addAOE(AreaOfEffect areaOfEffect) {

    }

    @Override
    public void addItem(Item item) {
        //Do nothing

    }

    @Override
    public void interactAOE(Character character) {
        //do nothing
    }

    @Override
    public void removeItem() {
        //Do nothing
    }

    @Override
    public void removeEntity() {
        MessageHandler.println("DirtTile: you shouldn't be removing entities", ErrorLevel.ERROR, PersonFilter.DAVID);
    }

    @Override
    public void addEntity(Entity entity) {
        MessageHandler.println("Dirt tile: you shouldn't be adding entities in here", ErrorLevel.ERROR, PersonFilter.DAVID);
    }
}
