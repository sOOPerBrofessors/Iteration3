package Utilities.GameFactory;

import Model.Map.Map;
import Model.Map.Tile.AirTile;
import Model.Map.Tile.GrassTile;
import Model.Map.Tile.RiverTile;
import Model.Map.Tile.WaterTile;
import Model.Map.TileColumn;

/**
 * Created by dyeung on 4/15/16.
 */
public class MapFactory {
    private int maxTileRow = 15;
    private int maxTileCol = 15;
    public MapFactory(int maxRow, int maxCol){
        maxTileRow = maxRow;
        maxTileCol = maxCol;
        //implement various types later
    }
    public Map createNewMap() {
        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
        for (int i = 0; i < maxTileRow; i++) {
            for (int j = 0; j < maxTileCol; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k < 1) {
                        if ((i == 2 || i == 1) && (j > 2 && j < 6)) {
                            tC.visitWaterTile(new WaterTile());
                        } else {
                            tC.visitGrassTile(new GrassTile());
                        }
                    } else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.visitGrassTile(new GrassTile());
                        } else {
                            tC.visitAirTile(new AirTile());
                        }
                    }
                }
            }
        }
        return new Map(tmpList);
    }
    public Map createNewMapRiver(){
        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
        for (int i = 0; i < maxTileRow; i++) {
            for (int j = 0; j < maxTileCol; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k < 1) {
                        if ((i == 2 || i == 1) && (j > 2 && j < 8)) {
                            tC.visitWaterTile(new RiverTile());
                        } else {
                            tC.visitGrassTile(new GrassTile());
                        }
                    } else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.visitGrassTile(new GrassTile());
                        } else {
                            tC.visitAirTile(new AirTile());
                        }
                    }
                }
            }
        }
        return new Map(tmpList);
    }
}
