package Utilities;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Settings {

    public static String TITLE = "sOOPer Brogrammers!";

    public static int GAMEWIDTH = 800;
    public static int GAMEHEIGHT = 600;
    public static boolean debug = false;

    // Key Presses

    public static int NORTH = 90;
    public static int NE = 45;
    public static int SE = 315;
    public static int SOUTH = 270;
    public static int SW = 225;
    public static int NW = 135;

    // adjustable keys

    public static int UP_RIGHT = 105;
    public static int UP = 104;
    public static int UP_LEFT = 103;
    public static int DOWN_LEFT = 97;
    public static int DOWN = 98;
    public static int DOWN_RIGHT = 99;

    public static int ATTACK = 32;
    public static int EQUIP = 69;
    public static int INVENTORY = 73;

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
    public static int INTERACT = 81;
    public static int SKILLS = 0x53;

    // End Key Presses

    public static void setDebug() { debug = true; }

    public static int TILEWIDTH = 56;
    public static int TILEHEIGHT = 48;
}