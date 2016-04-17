package Utilities;

import java.util.ArrayList;

/**
 * Created by broskj on 4/17/16.
 */
public class DamageQueue {
    private static ArrayList<DamageObject> damage = new ArrayList<>();

    public static ArrayList<DamageObject> getAll() {
        return damage;
    } // end getAll

    public static void push(DamageObject object) {
        damage.add(object);
    } // end push

    public static void pop() {
        if(damage.size() > 0)
            damage.remove(0);
    } // end pop

    public static int size() {
        return damage.size();
    } // end size
} // end class DamageQueue
