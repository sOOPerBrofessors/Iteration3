package View.TerrainView;

import Model.Map.Location;
import Model.Map.Tile.Tile;
import Utilities.Settings;
import Utilities.SpriteImageFactory;
import View.ViewUtilities.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/7/16.
 */
public class WaterTileView extends TileView {
    //private String url = "./res/terrain/water2.png";
    public WaterTileView(Tile tile) {
        super(tile);
        //image = SpriteImageFactory.getImage(url);
        image = ImageAssets.water;
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        //System.out.println("GrassTileView: paint component: " + location.getX() + "," + location.getY());
//        g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
//        String debug = location.getX() + "," + location.getY();
//        Font f = new Font("Courier New", 1, 12);
//        g.setFont(f);
//        g.drawString(debug, xPixel+ (tileWidth/3), yPixel + (tileHeight/2));

        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.drawImage(image,xPixel* Settings.SCALEFACTOR,yPixel*Settings.SCALEFACTOR,tileWidth*Settings.SCALEFACTOR,tileHeight* Settings.SCALEFACTOR,null);
//        g.setColor(Color.GREEN);
//        g.drawRect(xPixel,yPixel,tileWidth,tileHeight);

        String debug = location.getX() + "," + location.getY();
        Font f = new Font("Courier New", 1, 12);

        g2d.setFont(f);
        g2d.drawString(debug, (xPixel+ (tileWidth/3))*Settings.SCALEFACTOR, (yPixel + (tileHeight/2))*Settings.SCALEFACTOR);
        g2d.dispose();

        renderEntity(g2d);
        g2d.dispose();
    }
}
