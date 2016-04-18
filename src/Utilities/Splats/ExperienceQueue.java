package Utilities.Splats;

import Utilities.Observers.Observer;

import java.util.ArrayList;

/**
 * Created by broskj on 4/17/16.
 */
public class ExperienceQueue implements Observer {
    private final ArrayList<ExperienceSplat> experience = new ArrayList<>();

    public ArrayList<ExperienceSplat> getAll() {
        return experience;
    } // end getAll

    public void push(ExperienceSplat object) {
        experience.add(object);
    } // end push

    private void pop() {
        if(experience.size() > 0)
            experience.remove(0);
    } // end pop

    public int size() {
        return experience.size();
    } // end size

    @Override
    public void update() {
        pop();
    }

    @Override
    public void remove() {

    }
}
