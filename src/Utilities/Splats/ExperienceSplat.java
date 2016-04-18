package Utilities.Splats;

import Controller.ControllerUtility.Command;
import Utilities.Observers.Observer;
import Utilities.Observers.Subject;
import Utilities.Timer.DamageTimer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by broskj on 4/17/16.
 */
public class ExperienceSplat implements Subject {
    private int experience;
    private int xDelta;
    private int yDelta;
    private DamageTimer timer;
    private int r,g,b,a;
    private ArrayList<Observer> observers;

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
                alert();
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

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void alert() {
        for(Observer o : observers) {
            o.update();
        }
    }
}
