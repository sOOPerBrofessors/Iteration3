package Utilities.Splats;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by broskj on 4/17/16.
 */
public class DamageQueue implements Observer {
    private final ArrayList<DamageSplat> damage = new ArrayList<>();

    public ArrayList<DamageSplat> getAll() {
        return damage;
    } // end getAll

    public void push(DamageSplat object) {

        damage.add(object);
    } // end push

    private void pop() {
        if(damage.size() > 0)
            damage.remove(0);
    } // end pop

    public int size() {
        return damage.size();
    } // end size

    @Override
    public void update(Observable o, Object arg) {
        pop();
    }
} // end class DamageQueue
