package com.tripenyazaraz.noita.ui.cmd;

import com.tripenyazaraz.noita.logic.engine.Engine;
import com.tripenyazaraz.noita.logic.engine.Matrix;

public class ConsoleOutput extends Thread {

    private volatile Matrix matrix;

    public ConsoleOutput(Engine engine) {
        this.matrix = engine.matrix;
    }

    @Override
    public void run() {

        for (int y = 0; y < matrix.height; y++) {
            for (int x = 0; x < matrix.width; x++) {
                System.out.println();
            }
        }
    }

}
