package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.powder.Sand;

public class Engine {

    public static final Field field = new Field(10, 10);

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
        field.getField()[5][5] = new Sand(5, 5);
        field.getField()[5][4] = new Sand(5, 4);
        field.getField()[5][2] = new Sand(5, 2);
        field.getField()[5][1] = new Sand(5, 1);
        Thread physicsThread = new Thread(() -> {
            while (true) {
                if (!paused) {
                    field.physicsStep();
                    consoleOutput();
                }
            }
        });
        physicsThread.start();
    }

    public void consoleOutput() {
        for (int y = field.getField()[0].length-1; y >= 0; y--) {
            for (int x = 0; x < field.getField().length; x++) {
                System.out.print(field.getField()[x][y] instanceof Sand ? "S " : "O ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }

}

