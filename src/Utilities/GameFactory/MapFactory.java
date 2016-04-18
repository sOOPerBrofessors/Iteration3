package Utilities.GameFactory;

import Model.Map.Map;
import Model.Map.Tile.Terrain.RiverTerrain;
import Model.Map.Tile.Tile;
import Model.Map.TileColumn;
import Model.Map.Tile.Terrain.AirTerrain;
import Model.Map.Tile.Terrain.GrassTerrain;
import Model.Map.Tile.Terrain.WaterTerrain;

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
                            tC.addWaterTile(new Tile(new WaterTerrain()));
                        } else {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        }
                    } else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        } else {
                            tC.addAirTile(new Tile(new AirTerrain()));
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
                            tC.addWaterTile(new Tile(new RiverTerrain()));
                        } else {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        }
                    } else {
                        if (j == 8 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        } else {
                            tC.addAirTile(new Tile(new AirTerrain()));
                        }
                    }
                }
            }
        }
        return new Map(tmpList);
    }

}
