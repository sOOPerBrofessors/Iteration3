package View.ViewUtilities;

import java.awt.image.BufferedImage;

/**
 * Created by sgl on 4/6/16.
 */
public class ImageAssets {

    private static final int width = 96; //width and height of sprites
    private static final int height = 96;

    public static BufferedImage smasherSW, smasherNW, smasherN, smasherNE, smasherSE, smasherS;
    public static BufferedImage sneakSW, sneakNW, sneakN, sneakNE, sneakSE, sneakS;
    public static BufferedImage grass;

    //needs to be called once
    public static void init(){
        SpriteSheet smasherSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Smasher.png"));
        SpriteSheet sneakSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Sneak.png"));
        SpriteSheet terrainSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/grass.png"));

        smasherSW = smasherSheet.cropSheet(0,0, width, height);
        smasherNW = smasherSheet.cropSheet(width*1, 0, width, height);
        smasherN = smasherSheet.cropSheet(width*2, 0, width, height);
        smasherNE = smasherSheet.cropSheet(width*3, 0, width, height);
        smasherSE = smasherSheet.cropSheet(width*4, 0, width, height);
        smasherS = smasherSheet.cropSheet(width*5, 0, width, height);

        sneakSW = sneakSheet.cropSheet(0,0, width, height);
        sneakNW = sneakSheet.cropSheet(width*1, 0, width, height);
        sneakN = sneakSheet.cropSheet(width*2, 0, width, height);
        sneakNE = sneakSheet.cropSheet(width*3, 0, width, height);
        sneakSE = sneakSheet.cropSheet(width*4, 0, width, height);
        sneakS = sneakSheet.cropSheet(width*5, 0, width, height);

        grass = terrainSheet.cropSheet(0,0, width, height);

    }
}
