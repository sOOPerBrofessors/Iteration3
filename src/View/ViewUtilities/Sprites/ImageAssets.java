package View.ViewUtilities.Sprites;

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
    private static final int summonerWidth = 44;
    private static final int summonerHeight = Settings.ENTITYHEIGHT;
    private static final int enemyWidth = 44;
    private static final int enemyHeight = Settings.ENTITYHEIGHT;
    private static final int terrainWidth = 96;
    private static final int terrainHeight = 72;

    public static BufferedImage smasherSW, smasherNW, smasherN, smasherNE, smasherSE, smasherS;
    public static BufferedImage sneakSW, sneakNW, sneakN, sneakNE, sneakSE, sneakS;
    public static BufferedImage summonerS,summonerSW, summonerNW, summonerN, summonerNE, summonerSE;
    public static BufferedImage enemyS, enemySW, enemyNW, enemyN, enemyNE, enemySE;
    public static BufferedImage crabS, crabSW, crabNW, crabN, crabNE, crabSE;
    public static BufferedImage grass, grass2, dirt, water;
    public static BufferedImage invSlot, eqSlot, select;
    public static BufferedImage hud, messageBox, interfaceBorder;

    // items
    public static BufferedImage healthPotion;
    public static BufferedImage sword;
    public static BufferedImage itemBag;
    public static BufferedImage chestPlate;
    public static BufferedImage closedChest;
    public static BufferedImage openChest;
    public static BufferedImage money;
    public static BufferedImage chestKey;

    //needs to be called once
    public static void init(){
        SpriteSheet healthPotionSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/HealthPotion.png"));
        SpriteSheet chestKeySheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/key.png"));
        SpriteSheet moneySheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/Money.png"));
        SpriteSheet chestPlateSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/ChestPlate.png"));
        SpriteSheet closedChestSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/ClosedChest.png"));
        SpriteSheet openChestSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/OpenChest.png"));
        SpriteSheet itemBagSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/ItemBag.png"));
        SpriteSheet swordSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Item/Sword.png"));
        SpriteSheet smasherSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Smasher.png"));
        SpriteSheet sneakSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Sneak.png"));
        SpriteSheet EnemySummonerSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Enemy_Summoner.png"));
        SpriteSheet terrainSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/terrainsWithWater.png"));
        SpriteSheet waterSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/water2.png"));
        SpriteSheet invButtonsSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Buttons/InventoryButtons.png"));
        SpriteSheet hudSheet = new SpriteSheet(SpriteLoader.loadImage("./res/interface/hud.png"));
        SpriteSheet messageBoxSheet = new SpriteSheet(SpriteLoader.loadImage("./res/interface/messagebox.png"));
        SpriteSheet crabSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/crab.png"));
        SpriteSheet borderSheet = new SpriteSheet(SpriteLoader.loadImage("./res/interface/interfaceborder.png"));

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

        enemyS = EnemySummonerSheet.cropSheet(enemyWidth*0, 0, enemyWidth, enemyHeight);
        enemySW = EnemySummonerSheet.cropSheet(enemyWidth*1, 0, enemyWidth, enemyHeight);
        enemyNW = EnemySummonerSheet.cropSheet(enemyWidth*2, 0, enemyWidth, enemyHeight);
        enemyN = EnemySummonerSheet.cropSheet(enemyWidth*3, 0, enemyWidth, enemyHeight);
        enemyNE = EnemySummonerSheet.cropSheet(enemyWidth*4, 0, enemyWidth, enemyHeight);
        enemySE = EnemySummonerSheet.cropSheet(enemyWidth*5, 0, enemyWidth, enemyHeight);

        summonerS = EnemySummonerSheet.cropSheet(summonerWidth*6, 0, summonerWidth, summonerHeight);
        summonerSW = EnemySummonerSheet.cropSheet(summonerWidth*7, 0, summonerWidth, summonerHeight);
        summonerNW = EnemySummonerSheet.cropSheet(summonerWidth*8, 0, summonerWidth, summonerHeight);
        summonerN = EnemySummonerSheet.cropSheet(summonerWidth*9, 0, summonerWidth, summonerHeight);
        summonerNE = EnemySummonerSheet.cropSheet(summonerWidth*10, 0, summonerWidth, summonerHeight);
        summonerSE = EnemySummonerSheet.cropSheet(summonerWidth*11, 0, summonerWidth, summonerHeight);

        crabS = crabSW = crabSheet.cropSheet(0,50,100,50);
        crabSE = crabSheet.cropSheet(50,50,100,50);
        crabN = crabNE = crabSheet.cropSheet(100,50,100,50);
        crabNW = crabSheet.cropSheet(150,50,100,50);
        grass = terrainSheet.cropSheet(0,0,terrainWidth,terrainHeight);
        grass2 = terrainSheet.cropSheet(terrainWidth*2,0,terrainWidth,terrainHeight);
        dirt = terrainSheet.cropSheet(terrainWidth,0,terrainWidth,terrainHeight);
        water = waterSheet.cropSheet(0,0,terrainWidth,terrainHeight);

        invSlot = invButtonsSheet.cropSheet(0,0,60,60);
        eqSlot = invButtonsSheet.cropSheet(60,0,60,60);
        select = invButtonsSheet.cropSheet(120,0,60,60);

        hud = hudSheet.cropSheet(0,0,960,320);
        messageBox = messageBoxSheet.cropSheet(0,0,640,400);
        interfaceBorder = borderSheet.cropSheet(0,0,1080,720);

        //items
        healthPotion = healthPotionSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        sword = swordSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        itemBag = itemBagSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        chestPlate = chestPlateSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        openChest = openChestSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        closedChest = closedChestSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        money = moneySheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        chestKey = chestKeySheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
    }
}