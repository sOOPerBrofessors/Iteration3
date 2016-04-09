package View.AreaViewport;

import Model.Entity.Character.Avatar;
import Model.Map.Location;
import Model.Map.MapObjects;
import Model.Map.TileColumn;
import Utilities.Visitor.ColumnVisitor;
import Utilities.Visitor.TileVisitor;
import Model.Map.Map;
import View.EntityView.AvatarView;
import View.MapView.TileColumnView;
import View.TerrainView.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class MapViewFactory {
    public MapViewFactory(){

    }


    //TWO IDEAS: WE CAN EITHER CREATE AN ARRAYLIST OR CREATE A TILE VIEW
    public TileColumnView[][] createMapViewObjects(Map map){

        TileColumn[][] tC = map.getMapOfTiles();

        int maxRow = tC.length;
        int maxCol = tC[0].length;

        TileColumnView[][] tmp = new TileColumnView[maxRow][maxCol];
        for (int i = 0; i < tC.length; i++){
            for (int j = 0; j < tC[0].length; j++){
                tmp[i][j] = new TileColumnView(tC[i][j], new Location(i,j,0));
            }
        }
        return tmp;
    }

}
