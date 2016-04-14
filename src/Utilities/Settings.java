package Utilities;

import java.awt.event.KeyEvent;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Settings {

    public static String TITLE = "sOOPer Brogrammers!";

    public static int GAMEWIDTH = 800;
    public static int GAMEHEIGHT = 600;
    public static int SCALEFACTOR = 1;
    public static boolean debug = true;
    public static ErrorLevel errorLevel = ErrorLevel.NOTICE;
    public static PersonFilter personFilter = PersonFilter.ALL;

    // Key Presses
    public static int UP_ARROW = KeyEvent.VK_UP;
    public static int LEFT_ARROW = KeyEvent.VK_LEFT;
    public static int DOWN_ARROW = KeyEvent.VK_DOWN;
    public static int RIGHT_ARROW = KeyEvent.VK_RIGHT;
    public static int UP_RIGHT = KeyEvent.VK_E;
    public static int UP = KeyEvent.VK_W;
    public static int UP_LEFT = KeyEvent.VK_Q;
    public static int DOWN_LEFT = KeyEvent.VK_A;
    public static int DOWN = KeyEvent.VK_S;
    public static int DOWN_RIGHT = KeyEvent.VK_D;

    public static int ATTACK = 32;
    public static int EQUIP = 10001; //This was overwritting VK_E which is used for movement
    public static int INVENTORY = 73; // 'i'

    // end adjustable keys

    public static int TAB = 0x09;
    public static int ENTER = 10;
    public static int ESC = 0x1B;

    public static int SPACE = 32;
    public static int ONE = 0x31;
    public static int TWO = 0x32;
    public static int THREE = 0x33;
    public static int FOUR = 0x34;
    public static int DROP = 0x44;
    public static int MAP = 0x4D;
    public static int INTERACT = 1000; //This was overwriting the "Q" key which is used for movement.
    public static int SKILLS = 10001; //"originally"0x53 " s"This is most likely overwritting the "S" key which is used for movement;

    // End Key Presses

    public static void setDebug() { debug = true; }
    //Original grass
    public static int TILEWIDTH = 96;
    public static int TILEHEIGHT = 62; //used to be 48, shouldn't it be 62???
    public static int ENTITYWIDTH = 42;
    public static int ENTITYHEIGHT = 75;
    //Grass flat
//    public static int TILEWIDTH = 96;
//    public static int TILEHEIGHT = 62;

    public static final int MAX_INVENTORY_SIZE = 16;

}
