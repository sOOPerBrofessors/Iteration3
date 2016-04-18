package View.TerrainView;

import Model.Map.Tile.Terrain.Terrain;
import Utilities.Settings;
import Utilities.Visitor.TerrainVisitor;
import View.ViewUtilities.Sprites.ImageAssets;

import java.awt.*;

/**
 * Created by dyeung on 4/15/16.
 */
public class TerrainView implements TerrainVisitor{
    private Image image;
    private int xPixel;
    private int yPixel;
    private final int tileWidth = Settings.TILEWIDTH;
    private final int tileHeight = Settings.TILEHEIGHT;

    public TerrainView(Terrain terrain){
        Terrain terrain1 = terrain;
        //
        terrain.acceptTerrainVisitor(this);

    }
    //This will need to delete all sub class terrain views (?) possibly
    public void paintComponent(Graphics g, int xLocation, int yLocation) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        if (image != null) {
            g2d.drawImage(image, xPixel * Settings.SCALEFACTOR, yPixel * Settings.SCALEFACTOR, (tileWidth + 3) * Settings.SCALEFACTOR, (tileHeight + 5) * Settings.SCALEFACTOR, null);
            renderDebug(g,xLocation,yLocation);
        }
    }
    private void renderDebug(Graphics g, int xLocation, int yLocation){
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

    @Override
    public void visitWaterTerrain() {
        image = ImageAssets.water;
    }

    @Override
    public void visitGrassTerrain() {
        image = ImageAssets.grass;
    }

    @Override
    public void visitAirTerrain() {
        image = null;
    }

    @Override
    public void visitRiverTerrain() {
        image = ImageAssets.water;
    }

    @Override
    public void visitDirtTerrain() {
        image = ImageAssets.dirt;
    }
}
