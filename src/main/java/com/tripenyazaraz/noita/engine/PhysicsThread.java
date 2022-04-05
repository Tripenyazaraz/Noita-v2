package com.tripenyazaraz.noita.engine;

import static com.tripenyazaraz.noita.Context.*;

public class PhysicsThread extends Thread {

    private boolean isPaused = false;

    private long timeOutInMillis = 0;

    public void release() {
        this.isPaused = false;
    }

    public void pause() {
        this.isPaused = true;
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
                    sleep(timeOutInMillis);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                engine.field.physicsStep();
            }
        }
    }
}
