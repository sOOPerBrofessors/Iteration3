package View.ViewUtilities.Sprites;

import Utilities.Settings;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    public static BufferedImage shopKeeperSW, shopKeeperNW, shopKeeperN, shopKeeperNE, shopKeeperSE, shopKeeperS;
    public static BufferedImage enemyS, enemySW, enemyNW, enemyN, enemyNE, enemySE;
    public static BufferedImage crabS, crabSW, crabNW, crabN, crabNE, crabSE;
    public static BufferedImage birdS, birdSW, birdNW, birdN, birdNE, birdSE;
    public static BufferedImage grass;
    public static BufferedImage grass2;
    public static BufferedImage dirt;
    public static BufferedImage water;
    public static BufferedImage invSlot, eqSlot, select;
    public static BufferedImage hud, messageBox, interfaceBorder;
    public static BufferedImage mount;
    public static final ArrayList<BufferedImage> fireballs = new ArrayList<>();

    //skill things
    public static BufferedImage crackedEarth, arcaneExplosion;
    public static ArrayList<BufferedImage> arrows = new ArrayList<>();

    public static BufferedImage hellCatN, hellCatNW, hellCatSW, hellCatS, hellCatSE, hellCatNE;


    // items
    public static BufferedImage healthPotion;
    public static BufferedImage sword;
    public static BufferedImage itemBag;
    public static BufferedImage chestPlate;
    public static BufferedImage closedChest;
    public static BufferedImage openChest;
    public static BufferedImage money;
    public static BufferedImage chestKey;

    //AOE
    public static BufferedImage goldStarAOE;
    public static BufferedImage redCrossAOE;
    private static BufferedImage damageAOE;
    public static BufferedImage instantDeathAOE;
    public static BufferedImage teleportAOE;
    public static BufferedImage trapAOE;

    //needs to be called once
    public static void init(){
        SpriteSheet goldStarAOESheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/gold-star.png"));
        SpriteSheet redCrossAOESheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/red-cross.png"));
        SpriteSheet damageAOESheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/skull-and-crossbones.png"));
        SpriteSheet instantDeathAOESheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/skull-and-crossbones.png"));
        SpriteSheet teleportAOESheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/teleport-sample.png"));
        SpriteSheet trapImageSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Decal/trap.png"));

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
        SpriteSheet shopKeeperSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/ShopKeeper.png"));
        SpriteSheet mountSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Mount.png"));
        SpriteSheet birdSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/bird.png"));

        // Cracked earth
        SpriteSheet crackedEarthSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/crackedGrass.png"));
        SpriteSheet arcaneExplosionSheet = new SpriteSheet(SpriteLoader.loadImage("./res/terrain/arcaneExplosion.png"));
        // fireballs!
        SpriteSheet fireballSheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/FireBall.png"));
        SpriteSheet fireball90Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/FireBall90.png"));
        SpriteSheet fireball180Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/FireBall180.png"));
        SpriteSheet fireball270Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/FireBall270.png"));


        // projectiles!
        SpriteSheet arrow0Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow0.png"));
        SpriteSheet arrow60Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow60.png"));
        SpriteSheet arrow120Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow120.png"));
        SpriteSheet arrow180Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow180.png"));
        SpriteSheet arrow240Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow240.png"));
        SpriteSheet arrow300Sheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/Arrow300.png"));

        // hellcat!
        SpriteSheet hellcatNsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatN.png"));
        SpriteSheet hellcatNWsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatNW.png"));
        SpriteSheet hellcatSWsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatSW.png"));
        SpriteSheet hellcatSsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatS.png"));
        SpriteSheet hellcatSEsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatSE.png"));
        SpriteSheet hellcatNEsheet = new SpriteSheet(SpriteLoader.loadImage("./res/Entity/pet/hellcatNE.png"));


        smasherSW = smasherSheet.cropSheet(0,0, smasherWidth, smasherHeight);
        smasherNW = smasherSheet.cropSheet(smasherWidth*1, 0, smasherWidth, smasherHeight);
        smasherN = smasherSheet.cropSheet(smasherWidth*2, 0, smasherWidth, smasherHeight);
        smasherNE = smasherSheet.cropSheet(smasherWidth*3, 0, smasherWidth, smasherHeight);
        smasherSE = smasherSheet.cropSheet(smasherWidth*4, 0, smasherWidth, smasherHeight);
        smasherS = smasherSheet.cropSheet(smasherWidth*5, 0, smasherWidth, smasherHeight);

        shopKeeperSW = shopKeeperSheet.cropSheet(0,0, smasherWidth, smasherHeight);
        shopKeeperNW = shopKeeperSheet.cropSheet(smasherWidth*1, 0, smasherWidth, smasherHeight);
        shopKeeperN = shopKeeperSheet.cropSheet(smasherWidth*2, 0, smasherWidth, smasherHeight);
        shopKeeperNE = shopKeeperSheet.cropSheet(smasherWidth*3, 0, smasherWidth, smasherHeight);
        shopKeeperSE = shopKeeperSheet.cropSheet(smasherWidth*4, 0, smasherWidth, smasherHeight);
        shopKeeperS = shopKeeperSheet.cropSheet(smasherWidth*5, 0, smasherWidth, smasherHeight);

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

        crabS = crabSheet.cropSheet(0,0,100,100);
        crabSE = crabSheet.cropSheet(100,0,100,100);
        crabSW = crabSheet.cropSheet(900, 0, 100, 100);
        crabN = crabSheet.cropSheet(100,0,100,100);
        crabNW = crabSheet.cropSheet(200,0,100,100);
        crabNE = crabSheet.cropSheet(300, 0, 100, 100);

        birdN = birdNW = birdNE = birdSheet.cropSheet(220, 0, 30, 30);
        birdS = birdSW = birdSE = birdSheet.cropSheet(220, 100, 30, 30);

        grass = terrainSheet.cropSheet(0,0,terrainWidth,terrainHeight);
        grass2 = terrainSheet.cropSheet(terrainWidth*2,0,terrainWidth,terrainHeight);
        dirt = terrainSheet.cropSheet(terrainWidth,0,terrainWidth,terrainHeight);
        water = waterSheet.cropSheet(0,0,terrainWidth,terrainHeight);

        invSlot = invButtonsSheet.cropSheet(0,0,60,60);
        eqSlot = invButtonsSheet.cropSheet(60,0,60,60);
        select = invButtonsSheet.cropSheet(120,0,60,60);

        hud = hudSheet.cropSheet(0,0,960,320);
        messageBox = messageBoxSheet.cropSheet(0,0,640,400);
        interfaceBorder = borderSheet.cropSheet(0,0,810,540);

        mount = mountSheet.cropSheet(0,0,48,48);

        //items
        healthPotion = healthPotionSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        sword = swordSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        itemBag = itemBagSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        chestPlate = chestPlateSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        openChest = openChestSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        closedChest = closedChestSheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        money = moneySheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);
        chestKey = chestKeySheet.cropSheet(0,0,Settings.TAKABLEWIDTH, Settings.TAKABLEHEIGHT);

        // fireBall!
        fireballs.add(fireballSheet.cropSheet(0,0,Settings.PROJECTILEWIDTH,Settings.PROJECTILEHEIGHT));
        fireballs.add(fireball90Sheet.cropSheet(0,0,Settings.PROJECTILEWIDTH,Settings.PROJECTILEHEIGHT));
        fireballs.add(fireball180Sheet.cropSheet(0,0,Settings.PROJECTILEWIDTH,Settings.PROJECTILEHEIGHT));
        fireballs.add(fireball270Sheet.cropSheet(0,0,Settings.PROJECTILEWIDTH,Settings.PROJECTILEHEIGHT));

        hellCatN = hellcatNsheet.cropSheet(25,0,300,350);
        hellCatNW = hellCatN;//hellcatNWsheet.cropSheet(0,0,328,350);
        hellCatSW = hellCatN;//hellcatSWsheet.cropSheet(0,0,328,350);
        hellCatS = hellCatN;//hellcatSsheet.cropSheet(0,0,328,350);
        hellCatSE = hellCatN;//hellcatSEsheet.cropSheet(0,0,328,350);
        hellCatNE = hellCatN;//hellcatNEsheet.cropSheet(0,0,328,350);

        //Decals
        goldStarAOE = goldStarAOESheet.cropSheet(0,0,30,30);
        redCrossAOE = redCrossAOESheet.cropSheet(0,0,30,30);
        damageAOE = damageAOESheet.cropSheet(0,0,30,30);
        instantDeathAOE = instantDeathAOESheet.cropSheet(0,0,30,30);
        teleportAOE = teleportAOESheet.cropSheet(0,0,30,30);
        trapAOE = trapImageSheet.cropSheet(0,0,92,80);

        //skill things
        crackedEarth = crackedEarthSheet.cropSheet(0, 0, terrainWidth, 71);
        arcaneExplosion = arcaneExplosionSheet.cropSheet(0, 0, terrainWidth, 71);

    }
}