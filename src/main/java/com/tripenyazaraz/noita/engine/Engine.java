package com.tripenyazaraz.noita.engine;

public class Engine {

    public static final int FIELD_WIDTH = 1080;
    public static final int FIELD_HEIGHT = 1080;

    public static final Field field = new Field(FIELD_WIDTH, FIELD_HEIGHT);

    public Field getField() {
        return field;
    }

    private boolean paused = false;

    public void pause() {
        this.paused = true;
    }

    public void resume() {
        this.paused = false;
    }

    public Engine() {
        field.clearAll();
        Thread physicsThread = new Thread(() -> {
            while (true) {
                if (!paused) {
                    field.physicsStep();
                }
            }
        });
        physicsThread.start();
    }

}

