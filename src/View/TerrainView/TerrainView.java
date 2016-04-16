package View.TerrainView;

import Utilities.Settings;

import java.awt.*;

/**
 * Created by dyeung on 4/15/16.
 */
public abstract class TerrainView {
    protected Image image;
    protected int xPixel;
    protected int yPixel;
    protected int tileWidth = Settings.TILEWIDTH;
    protected int tileHeight = Settings.TILEHEIGHT;
    public TerrainView(Image image){
        this.image = image;
    }
    public abstract void paintComponent(Graphics g);

    public void renderDebug(Graphics g, int xLocation, int yLocation){
        Graphics2D g2d = (Graphics2D) g.create();
        String debug = xLocation + "," + yLocation;
        Font f = new Font("Courier New", 1, 12);
        g2d.setFont(f);
        g2d.drawString(debug, (xPixel+ (tileWidth/3))*Settings.SCALEFACTOR, (yPixel + (tileHeight/2))*Settings.SCALEFACTOR);
        g2d.dispose();
    }
    public void setXY(int x, int y){
        xPixel = x;
        yPixel = y;
    }

}
