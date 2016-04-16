package View.TerrainView;

import Model.Map.Tile.Tile;
import Utilities.Settings;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public class DirtTileView extends TileView{
    //private String url = "./res/terrain/grass.png"; //For now it'll look like a grass tile
    public DirtTileView(Tile tile){
        super(tile);
        //image = SpriteImageFactory.getImage(url);
        image = ImageAssets.dirt;
    }
    @Override
    public void paintComponent(Graphics g) {

        //g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
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
    }
}
