package View.AreaViewport.FogOfWar;

import View.MapView.TileColumnView;

import java.awt.*;

/**
 * Created by dyeung on 4/13/16.
 */
//Tile state in reference to fog of war
public abstract class TileViewState {
    public abstract void drawState(TileColumnView tileColumnView, Graphics g);
}
