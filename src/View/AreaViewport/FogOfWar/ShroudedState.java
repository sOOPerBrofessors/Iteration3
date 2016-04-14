package View.AreaViewport.FogOfWar;

import View.MapView.TileColumnView;

import java.awt.*;

/**
 * Created by dyeung on 4/13/16.
 */
public class ShroudedState extends TileViewState{
    @Override
    public void drawState(TileColumnView tileColumnView, Graphics g) {
        tileColumnView.paintShrouded(g);
    }
}
