package Utilities;

import java.awt.event.KeyEvent;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Settings {

    public static final String TITLE = "sOOPer Brogrammers!";

    public static final int GAMEWIDTH = 1080;
    public static final int GAMEHEIGHT = 720;
    public static final int SCALEFACTOR = 1;

    public static final int SPAWN_X = 5;
    public static final int SPAWN_Y = 5;
    public static final int SPAWN_Z = 0;

    private static boolean debug = true;

    //CHANGEABLE IN SETTINGS
    public static int UP = KeyEvent.VK_W;
    public static int UP_LEFT = KeyEvent.VK_Q;
    public static int UP_RIGHT = KeyEvent.VK_E;
    public static int DOWN = KeyEvent.VK_S;
    public static int DOWN_LEFT = KeyEvent.VK_A;
    public static int DOWN_RIGHT = KeyEvent.VK_D;
    public static int ATTACK = 32;
    public static int INTERACT = KeyEvent.VK_ENTER; //This was overwriting the "Q" key which is used for movement.
    public static int SKILL_1 = KeyEvent.VK_1;
    public static int SKILL_2 = KeyEvent.VK_2;
    public static int SKILL_3 = KeyEvent.VK_3;
    public static int SKILL_4 = KeyEvent.VK_4;
    public static int SKILL_5 = KeyEvent.VK_5;
    public static int SKILL_6 = KeyEvent.VK_6;
    public static int SKILL_7 = KeyEvent.VK_7;
    public static int INVENTORY = KeyEvent.VK_I; // 'i'
    public static int STATS = KeyEvent.VK_O;
    public static int SKILLS = KeyEvent.VK_K; //"originally"0x53 " s"This is most likely overwritting the "S" key which is used for movement;


    public static final int RIGHT_ARROW = KeyEvent.VK_RIGHT;
    public static final int DOWN_ARROW = KeyEvent.VK_DOWN;
    public static final int LEFT_ARROW = KeyEvent.VK_LEFT;
    public static final int UP_ARROW = KeyEvent.VK_UP;
    public static final int TEST_KEY = KeyEvent.VK_T;

    public static int EQUIP = 10001; //This was overwritting VK_E which is used for movement
    public static final int DROP = KeyEvent.VK_D;

    public static final int SETTINGS = KeyEvent.VK_L;
    // end adjustable keys

    public static int TAB = 0x09;
    public static final int ENTER = 10;
    public static final int ESC = 0x1B;

    public static int SPACE = 32;
    public static int ONE = 0x31;
    public static int TWO = 0x32;
    public static int THREE = 0x33;
    public static int FOUR = 0x34;
    public static int FIVE = 0x35;
    public static int SIX = 0x36;
    public static int SEVEN = 0x37;
    public static final int EIGHT = 0x38;
    //public static int DROP = 0x44;
    public static int MAP = 0x4D;


    // End Key Presses

    public static void setDebug() { debug = true; }
    //Original grass
    public static final int TILEWIDTH = 96;
    public static final int TILEHEIGHT = 62; //used to be 48, shouldn't it be 62???
    public static final int ENTITYWIDTH = 42;
    public static final int ENTITYHEIGHT = 75;

    public static final int TAKABLEWIDTH = 32;
    public static final int TAKABLEHEIGHT = 32;

    public static final int INTERACTABLEWIDTH = 48;
    public static final int INTERACTABLEHEIGHT = 48;

    public static final int PROJECTILEHEIGHT = 32;
    public static final int PROJECTILEWIDTH = 32;

    public static final int MOUNTHEIGHT = 48;
    public static final int MOUNTWIDTH = 48;

    public static final int MAX_INVENTORY_SIZE = 16;

    // int to limit character count in game window
    public static final int CHAR_LIMIT = 63;
}
