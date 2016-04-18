package Utilities.GameFactory;

import Model.Map.Map;
import Model.Map.Orientation;
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
        createPartOne(tmpList);
        for (int i = 0; i < maxTileRow/2; i++) {
            for (int j = 0; j < maxTileCol/2; j++) {
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
                        if ((i == 2 ) && (j > 2 && j < 8)) {
                            tC.addRiverTile(new Tile(new RiverTerrain(Orientation.SOUTH)));
                        }else if ((i == 1) && (j > 2 && j < 8)) {
                            tC.addRiverTile(new Tile(new RiverTerrain(Orientation.NORTH)));
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

    public Map createSeparateMap(){
        TileColumn[][] tmpList = new TileColumn[maxTileRow][maxTileCol];
//        createLines(tmpList);
        createPartOne(tmpList);
        createPartTwo(tmpList);
        createPartThree(tmpList);
        createPartFour(tmpList);
        createLines(tmpList);
        addSpecificTiles(tmpList);
        return new Map(tmpList);
    }

    private void createPartOne(TileColumn[][] tmpList){
        for (int i = 0; i < maxTileRow/2; i++) {
            for (int j = 0; j < maxTileCol/2; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k < 1) {
                        if ((i == 2 ) && (j > 2 && j < 8)) {
                            tC.addRiverTile(new Tile(new RiverTerrain(Orientation.SOUTH)));
                        }else if ((i == 1) && (j > 2 && j < 8)) {
                            tC.addRiverTile(new Tile(new RiverTerrain(Orientation.NORTH)));
                        } else {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        }

                    } else {
                        if (i == 0 && j > 1 && k < j) {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        }else {
                            tC.addAirTile(new Tile(new AirTerrain()));
                        }
                    }
                }
            }
        }
    }
    private void createPartTwo(TileColumn[][] tmpList){
        for (int i = maxTileRow/2; i < maxTileRow; i++) {
            for (int j = 0; j < maxTileCol/2; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k<3) {
                        tC.addGrassTile(new Tile(new GrassTerrain()));
                    }else{
                        tC.addAirTile(new Tile(new AirTerrain()));
                    }
                }
            }
        }
    }
    private void createPartThree(TileColumn[][] tmpList){
        for (int i = 0; i < maxTileRow/2; i++) {
            for (int j = maxTileCol/2; j < maxTileCol; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k<3) {
                        if  (j == 9){
                            tC.addRiverTile(new Tile(new RiverTerrain(Orientation.SOUTHEAST)));
                        }else {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        }
                    }else{
                        if (j == 10 && (i >= 2 && i <= 9) && k < (i)) {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        } else {
                            tC.addAirTile(new Tile(new AirTerrain()));
                        }
                    }
                }
            }
        }
    }
    private void createPartFour(TileColumn[][] tmpList){
        for (int i = maxTileRow/2; i < maxTileRow; i++) {
            for (int j = maxTileCol/2; j < maxTileCol; j++) {
                tmpList[i][j] = new TileColumn();
                for (int k = 0; k < 10; k++) {
                    TileColumn tC = tmpList[i][j];
                    if (k<1) {
                        tC.addGrassTile(new Tile(new GrassTerrain()));
                    }else{
                        if ((i == 14) && j < 8 && k < 2) {
                            tC.addGrassTile(new Tile(new GrassTerrain()));
                        } else {
                            tC.addAirTile(new Tile(new AirTerrain()));
                        }
                    }
                }
            }
        }
    }

    private void createLines(TileColumn[][] tmpList){

    }
    private void addSpecificTiles(TileColumn[][] tmpList){

        tmpList[14][7].addGrassTile(new Tile (new GrassTerrain()));
    }

}
