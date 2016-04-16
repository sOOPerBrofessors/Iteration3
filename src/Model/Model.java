package Model;

import Model.State.StateManager;

/**
 * Created by Wimberley on 3/23/16.
 */
public class Model implements Runnable{

    private StateManager stateManager;

    private final int TICK_RATE = 60 ;
    private final int TARGET_TIME = 1000 / TICK_RATE;

    public Model(){
        stateManager = new StateManager();
    }

    public synchronized void start(){
        new Thread(this).start();
    }


    //feel free to overdo this Mike, just thought I'd put it in here for now
    @Override
    public void run() {

        long lastTime;
        long delta;
        long waitTime;

        while (true) {

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
    }

    public StateManager getStateManager() {
        return stateManager;
    }
}

