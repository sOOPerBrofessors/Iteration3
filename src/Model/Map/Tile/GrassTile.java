package Model.Map.Tile;

import Model.Map.Location;
import Model.Map.Tile.TileStrategy.CharTileStrategy;
import Utilities.Visitor.TileVisitor;
import View.TerrainView.TileView;

/**
 * Created by sgl on 4/5/16.
 */

//This tile can hold LandEntities and items
public class GrassTile extends MobileTile {

    //private ArrayList<Item> itemList = new ArrayList<Item>();

    public GrassTile(){
        super(new CharTileStrategy());
    }

    @Override
    public TileView acceptTileVisitor(TileVisitor tv, Location location) {
        return tv.createGrassTile(location);
    }
}
