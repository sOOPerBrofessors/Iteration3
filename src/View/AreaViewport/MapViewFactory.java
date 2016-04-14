package View.AreaViewport;

import Model.Map.Location;
import Model.Map.TileColumn;
import Model.Map.Map;
import View.MapView.TileColumnView;
import View.ViewUtilities.ImageAssets;

/**
 * Created by dyeung on 4/7/16.
 */
public class MapViewFactory {
    public MapViewFactory(){
        ImageAssets.init(); //intializes all the image assest so I can call them statically later
    }


    public MapView createMapViewObjects(Map map){

        TileColumn[][] tC = map.getMapOfTiles();

        int maxRow = tC.length;
        int maxCol = tC[0].length;

        TileColumnView[][] tmp = new TileColumnView[maxRow][maxCol];
        for (int i = 0; i < tC.length; i++){
            for (int j = 0; j < tC[0].length; j++){
                tmp[i][j] = new TileColumnView(tC[i][j], new Location(i,j,0));
            }
        }
        return new MapView(tmp);
    }

}
