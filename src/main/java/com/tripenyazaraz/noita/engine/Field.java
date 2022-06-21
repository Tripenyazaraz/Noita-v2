package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.Particle;
import com.tripenyazaraz.noita.particle.Void;

public class Field {

    private final int length;
    private final int width;
    private final Particle[][] field;

    public Field(int length, int width) {
        this.length = length;
        this.width = width;
        this.field = new Particle[length][width];
        this.clear();
    }

    private void clear() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j] = new Void();
            }
        }
    }

    public void step() {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                field[i][j].step();
            }
        }
    }
}
