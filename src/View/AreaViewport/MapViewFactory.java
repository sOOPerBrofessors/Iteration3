package View.AreaViewport;

import Model.Map.Location;
import Model.Map.Tile.WaterTile;
import Model.Map.TileColumn;
import Utilities.Visitor.TileVisitor;
import Model.Map.Map;
import View.TerrainView.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class MapViewFactory implements TileVisitor {
    public MapViewFactory(){

    }


    //TWO IDEAS: WE CAN EITHER CREATE AN ARRAYLIST OR CREATE A TILE VIEW
    public TileView[][][] createMapViewObjects(Map map){

        TileColumn[][] tC = map.getMapOfTiles();

        int maxRow = tC.length;
        int maxCol = tC[0].length;
        int maxHeight = 10;

        TileView[][][] tmp = new TileView[maxRow][maxCol][maxHeight];
        for (int i = 0; i < tC.length; i++){
            for (int j = 0; j < tC[0].length; j++){
                for (int k = 0; k < 10; k++){
                    Location location = new Location(i,j,k);
                    tmp[i][j][k] = tC[i][j].getTileList().get(k).acceptTileVisitor(this,location);
                }
            }
        }
        return tmp;
    }

    @Override
    public TileView createWaterTile(Location location) {
        return new WaterTileView(location);
    }

    @Override
    public TileView createGrassTile(Location location) {
        return new GrassTileView(location);
    }

    @Override
    public TileView createAirTile(Location location) {
        return new AirTileView(location);
    }

    @Override
    public TileView createRiverTile(Location location) {
        return new RiverTileView(location);
    }
}
