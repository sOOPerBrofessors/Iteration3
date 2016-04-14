package View.ViewUtilities;

import Utilities.Settings;

import java.awt.image.BufferedImage;

/**
 * Created by sgl on 4/6/16.
 */
public class ImageAssets {

    //private static final int width = 96; //width and height of sprites
    //private static final int height = 96;
    private static final int sneakWidth = Settings.ENTITYWIDTH; //width and height of sprites
    private static final int sneakHeight = Settings.ENTITYHEIGHT;
    private static final int smasherWidth = Settings.ENTITYWIDTH; //width and height of sprites
    private static final int smasherHeight = Settings.ENTITYHEIGHT;
    private static final int terrainWidth = 96;
    private static final int terrainHeight = 72;

    public static BufferedImage smasherSW, smasherNW, smasherN, smasherNE, smasherSE, smasherS;
    public static BufferedImage sneakSW, sneakNW, sneakN, sneakNE, sneakSE, sneakS;
    public static BufferedImage grass, grass2, dirt, water;

    //needs to be called once
    public static void init(){
        SpriteSheet smasherSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Smasher.png"));
        SpriteSheet sneakSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Sneak.png"));
        SpriteSheet terrainSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/terrainsWithWater.png"));
        SpriteSheet waterSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/water2.png"));

        smasherSW = smasherSheet.cropSheet(0,0, smasherWidth, smasherHeight);
        smasherNW = smasherSheet.cropSheet(smasherWidth*1, 0, smasherWidth, smasherHeight);
        smasherN = smasherSheet.cropSheet(smasherWidth*2, 0, smasherWidth, smasherHeight);
        smasherNE = smasherSheet.cropSheet(smasherWidth*3, 0, smasherWidth, smasherHeight);
        smasherSE = smasherSheet.cropSheet(smasherWidth*4, 0, smasherWidth, smasherHeight);
        smasherS = smasherSheet.cropSheet(smasherWidth*5, 0, smasherWidth, smasherHeight);

        sneakSW = sneakSheet.cropSheet(0,0, sneakWidth, sneakHeight);
        sneakNW = sneakSheet.cropSheet(sneakWidth*1, 0, sneakWidth, sneakHeight);
        sneakN = sneakSheet.cropSheet(sneakWidth*2, 0, sneakWidth, sneakHeight);
        sneakNE = sneakSheet.cropSheet(sneakWidth*3, 0, sneakWidth, sneakHeight);
        sneakSE = sneakSheet.cropSheet(sneakWidth*4, 0, sneakWidth, sneakHeight);
        sneakS = sneakSheet.cropSheet(sneakWidth*5, 0, sneakWidth, sneakHeight);

//      grass = terrainSheet.cropSheet(0,0, width, height);

        grass = terrainSheet.cropSheet(0,0,terrainWidth,terrainHeight);
        grass2 = terrainSheet.cropSheet(terrainWidth*2,0,terrainWidth,terrainHeight);
        dirt = terrainSheet.cropSheet(terrainWidth,0,terrainWidth,terrainHeight);
        water = waterSheet.cropSheet(0,0,terrainWidth,terrainHeight);


    }

}
