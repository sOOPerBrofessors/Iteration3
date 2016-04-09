package Model.Map.Tile;

import Model.Map.Location;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;
import Model.Entity.Entity;

/**
 * Created by sgl on 4/5/16.
 */

//This tile can hold LandEntities and items
public class GrassTile extends MobileTile {

    //private ArrayList<Item> itemList = new ArrayList<Item>();

    public GrassTile(){
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv) {
        return tv.createGrassTile();
    }

    public boolean moveChar(Entity entity){
        super.entity = entity;
        // entity.setLocation();
        return true;
    }


}
