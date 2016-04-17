package Utilities.Splats;

import Controller.ControllerUtility.Command;
import Utilities.Timer.DamageTimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by broskj on 4/17/16.
 */
public class ExperienceQueue {
    private static ArrayList<ExperienceSplat> experience = new ArrayList<>();

    public static ArrayList<ExperienceSplat> getAll() {
        return experience;
    } // end getAll

    public static void push(ExperienceSplat object) {
        experience.add(object);
    } // end push

    public static void pop() {
        if(experience.size() > 0)
            experience.remove(0);
    } // end pop

    public static int size() {
        return experience.size();
    } // end size

    /**
     * Created by broskj on 4/17/16.
     */
    public static class ExperienceSplat {
        private int experience;
        private int xDelta;
        private int yDelta;
        private DamageTimer timer;
        private int r,g,b,a;

        public ExperienceSplat(int experience) {
            r = g = 255;
            b = 0;
            a = 255;
            this.experience = experience;
            yDelta = 0;
            xDelta = (int)(Math.random()*32);
            xDelta *= Math.pow(-1,(int)(Math.random() * 2));
            timer = new DamageTimer(new Command() {
                @Override
                public void execute() {

                }
            }, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pop();
                }
            });
        }

        public int getExperience() { return experience; }
        public int getyDelta() { return yDelta; }
        public int getxDelta() { return xDelta; }
        public void start() { timer.start(); }
        public Color getColor() { return new Color(r,g,b,a); }
        public boolean isRunning() { return timer.isRunning(); }
        public void decrementyDelta() { --yDelta; }
        public void decrementAlpha() { if(a-8 >= 0) a-=8; }

    } // end class DamageSplat
}
