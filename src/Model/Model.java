package Model;

import Model.State.StateManager;
import Utilities.ErrorLevel;
import Utilities.MessageHandler;
import Utilities.PersonFilter;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Model implements Runnable{

    private StateManager stateManager;

    private final int TICK_RATE = 60 ;
    private final int TARGET_TIME = 1000 / TICK_RATE;
    private volatile boolean running = true;


    public Model(){
        stateManager = new StateManager(this);
    }

    public void terminate() { running = false; }

    public void restart() {running = true;}

    public synchronized void start(){
        if (!running) {
            running = true;
            MessageHandler.println("THREAD ALREADY STARTED!", ErrorLevel.CRITICAL, PersonFilter.SAM);
        }
        else {
            MessageHandler.println("new thread started", ErrorLevel.CRITICAL, PersonFilter.SAM);
            new Thread(this).start();
        }
    }

    @Override
    public void run() {

        long lastTime;
        long delta;
        long waitTime;

        while (running) {

            lastTime = System.nanoTime();

            stateManager.tick();

            delta = System.nanoTime() - lastTime;

            waitTime = TARGET_TIME - delta / 1000000;

            if (waitTime < TARGET_TIME) {
                waitTime = TARGET_TIME;
            }
            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            //Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    }

    public StateManager getStateManager() {
        return stateManager;
    }
}

