package Model.Map.Tile;

import Model.Items.Item;
import Model.Map.Location;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;
import Model.Entity.Entity;

import java.util.ArrayList;

/**
 * Created by sgl on 4/5/16.
 */

//This tile can hold LandEntities and items
public class GrassTile extends MobileTile {


    public GrassTile(){
    }

    @Override
    public void acceptTileVisitor(TileVisitor tv) {
        //TODO: ADD ITEM STUFF
        tv.visitGrassTile(this);
    }

    public boolean moveChar(Entity entity){

        if(super.entity == null) {
            super.entity = entity;
            notifyObservers();
            return true;
        } else {
            super.moveChar(entity);
            return false;
        }
    }

    public boolean canMoveChar() {
        return super.entity == null;
    }

}
