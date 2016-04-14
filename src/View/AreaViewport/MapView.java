package View.AreaViewport;

import Model.Map.Location;
import View.MapView.TileColumnView;

import java.awt.*;

/**
 * Created by dyeung on 4/13/16.
 */
public class MapView {
    private TileColumnView[][] tileColumnView;

    public MapView(TileColumnView[][] tileColumnView){
        this.tileColumnView = tileColumnView;
    }

    public int getXBound(){
        return tileColumnView.length;
    }
    public int getYBound(){
        return tileColumnView[0].length;
    }
    public void offsetCamera(Location offset, int x, int y){
        if (notOutBounds(x,y)){
            tileColumnView[x][y].offsetCamera(offset);
        }
    }
    public void render(Graphics g, int x, int y){
        //Check is already done previously
        tileColumnView[x][y].paintComponent(g);
    }
    private boolean notOutBounds(int x, int y){
        if (x < tileColumnView.length && y < tileColumnView[0].length){
            return true;
        }else{
            return false;
        }
    }
    public void setVisibleState(int x, int y){
        if (notOutBounds(x,y)){
            tileColumnView[x][y].setVisibleState();
        }
    }

}
