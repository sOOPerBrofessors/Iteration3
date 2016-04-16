package View.AreaViewport;

import Model.Map.Location;
import Model.Map.Map;
import Utilities.ItemStuff.ItemManager;
import View.ItemView.ItemView;
import View.MapView.TileColumnView;
import View.ViewUtilities.Sprites.ImageAssets;

import java.util.HashMap;

/**
 * Created by dyeung on 4/7/16.
 */
public class MapViewFactory {

    //gets views of items through itemManager
    public MapViewFactory(){
    }

    public MapView createMapViewObjects(Map map){

        int maxRow = map.getMaxRow();
        int maxCol = map.getMaxColumn();

        TileColumnView[][] tmp = new TileColumnView[maxRow][maxCol];
        for (int i = 0; i < maxRow; i++){
            for (int j = 0; j < maxCol; j++){
                tmp[i][j] = new TileColumnView(map.getTileColumn(i,j), new Location(i,j,0));
            }
        }
        return new MapView(tmp);
    }
}
