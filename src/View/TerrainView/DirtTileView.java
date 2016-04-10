package View.TerrainView;

import Model.Map.Tile.Tile;
import Utilities.SpriteImageFactory;

import java.awt.*;

/**
 * Created by dyeung on 4/9/16.
 */
public class DirtTileView extends TileView{
    private String url = "./res/terrain/grass.png"; //For now it'll look like a grass tile
    public DirtTileView(Tile tile){
        super(tile);
        image = SpriteImageFactory.getImage(url);
    }
    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(image,xPixel,yPixel,tileWidth,tileHeight,null);
    }
}
