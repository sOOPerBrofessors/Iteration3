package View.MapView;

import Model.Map.Location;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dyeung on 4/8/16.
 */

//This class is basically a type container for all of the other classes that can be rendered on a tile
    //This does not include the tile column or tiles (Only things that can be ontop of a tile)
public abstract class MapObjectView extends JComponent{
    public abstract void paintComponent(Graphics g);
    public abstract void setPixels(int x, int y);
}
