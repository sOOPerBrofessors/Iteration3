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
public class DamageQueue {
    private static ArrayList<DamageSplat> damage = new ArrayList<>();

    public static ArrayList<DamageSplat> getAll() {
        return damage;
    } // end getAll

    public static void push(DamageSplat object) {
        damage.add(object);
    } // end push

    public static void pop() {
        if(damage.size() > 0)
            damage.remove(0);
    } // end pop

    public static int size() {
        return damage.size();
    } // end size

    /**
     * Created by broskj on 4/17/16.
     */
    public static class DamageSplat {
        private int damage;
        private int xDelta;
        private int yDelta;
        private DamageTimer timer;
        private int r,g,b,a;

        public DamageSplat(int damage) {
            r = g = b = 0;
            a = 255;
            this.damage = damage;
            if(damage < 0) {
                r = 255;
            }
            else if(damage == 0) {
                b = 255;
            }
            else {
                g = 255;
            }
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

        public int getDamage() { return damage; }
        public int getyDelta() { return yDelta; }
        public int getxDelta() { return xDelta; }
        public void start() { timer.start(); }
        public Color getColor() { return new Color(r,g,b,a); }
        public boolean isRunning() { return timer.isRunning(); }
        public void decrementyDelta() { --yDelta; }
        public void decrementAlpha() { if(a-8 >= 0) a-=8; }

    } // end class DamageSplat
} // end class DamageQueue
