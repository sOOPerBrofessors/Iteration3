package View.TerrainView;

import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.SpriteImageFactory;

import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class WaterTileView extends TileView {
    private String url = "./res/terrain/water2.png";
    public WaterTileView(Tile tile) {
        super(tile);
        image = SpriteImageFactory.getImage(url);

    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + location.getX() + "," + location.getY());
        g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
        String debug = location.getX() + "," + location.getY();
        Font f = new Font("Courier New", 1, 12);
        g.setFont(f);
        g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));

        renderEntity(g);
    }
}
