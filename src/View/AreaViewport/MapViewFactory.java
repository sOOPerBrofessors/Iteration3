package View.AreaViewport;

import Model.Map.Location;
import Model.Map.Map;
import Model.Map.Tile.Tile;
import Model.Map.TileColumn;
import View.MapView.TileColumnView;
import View.MapView.TileView;


import java.util.ArrayList;

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
            for (int j = 0; j < maxCol; j++) {
                tmp[i][j] = createTileColumnView(map.getTileColumn(i,j), i,j);
            }
        }
        return new MapView(tmp);
    }
    public TileColumnView createTileColumnView(TileColumn tileColumn, int x , int y){
        ArrayList<TileView> tileViews = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            Tile t = tileColumn.getTileAt(i);
            TileView tileView = new TileView(t, new Location(x,y,i));
            tileViews.add(tileView);
        }
        return new TileColumnView(tileViews, new Location(x,y,0));
    }
}

