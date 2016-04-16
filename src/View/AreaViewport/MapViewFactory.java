package View.AreaViewport;

import Model.Map.Location;
import Model.Map.Map;
import View.MapView.TileColumnView;
import View.ViewUtilities.Sprites.ImageAssets;

/**
 * Created by dyeung on 4/7/16.
 */
public class MapViewFactory {
    public MapViewFactory(){
        ImageAssets.init(); //intializes all the image assest so I can call them statically later
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
