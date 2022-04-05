package com.tripenyazaraz.noita.ui;

import com.tripenyazaraz.noita.particle.powder.Sand;

import static com.tripenyazaraz.noita.Context.engine;
import static com.tripenyazaraz.noita.Utils.toInt;

public class MouseThread extends Thread {

    int x, y;

    private boolean isPaused = true;

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

    public MouseThread() {}

    public MouseThread(long timeOutInMillis) {
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
                engine.field.putParticle(new Sand(toInt(x), toInt(y)));
            }
        }
    }

}
