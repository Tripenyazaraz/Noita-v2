package com.tripenyazaraz.noita.engine;

import static com.tripenyazaraz.noita.Context.*;

public class PhysicsThread extends Thread {

    private boolean isPaused = false;

    private long timeOutInMillis = 0;

    public boolean release() {
        return isPaused;
    }

    public void pause(boolean paused) {
        isPaused = paused;
    }

    public void setTimeOut(long millis){
        this.timeOutInMillis = millis;
    }

    public PhysicsThread() {}

    public PhysicsThread(long timeOutInMillis) {
        this.setTimeOut(timeOutInMillis);
    }

    @Override
    public void run() {
        while (true) {
            if (!isPaused) {
                try {
                    wait(timeOutInMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                engine.field.physicsStep();
            }
        }
    }
}
