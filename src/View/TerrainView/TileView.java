package View.TerrainView;

import Model.Map.Location;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public abstract class TileView extends JComponent{
    protected Location location;
    public TileView(Location location){
        this.location = location;
    }
    public abstract void updateCameraOffset(Location location);

    public abstract void paintComponent(Graphics g);
}
