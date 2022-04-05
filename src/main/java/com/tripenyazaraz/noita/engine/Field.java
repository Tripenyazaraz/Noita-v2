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

    public int getWidth() {
        return this.getField().length;
    }

    public int getHeight() {
        return this.getField()[0].length;
    }

    public void clearAll() {
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                field[x][y] = new Void(x, y);
            }
        }
    }

    public void physicsStep() {
        for (Particle[] axis : field) {
            for (Particle particle : axis) {
                particle.step(this);
            }
        }
    }

    public boolean isInBounds(int x, int y) {
        return (x <= this.getWidth()-1 &&
                x >= 0 &&
                y <= this.getHeight()-1 &&
                y >= 0);
    }

    public boolean isEmpty(int x, int y) {
        return isInBounds(x, y) && this.getField()[x][y] instanceof Void;
    }

    public void putParticle(Particle particle) {
        assert(isInBounds(particle.getX(), particle.getY()));
        field[particle.getX()][particle.getY()] = particle;
    }
}
