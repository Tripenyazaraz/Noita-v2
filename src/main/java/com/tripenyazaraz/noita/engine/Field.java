package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.Particle;
import com.tripenyazaraz.noita.particle.special.Void;

public class Field {

    private final Particle[][] field;

    public Particle[][] getField() {
        return field;
    }

    public Field(int width, int height) {
        this.field = new Particle[width][height];
    }

    public void cleanAll() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                field[x][y] = new Void(x, y);
            }
        }
    }
}
