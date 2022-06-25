package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.engine.Matrix;
import com.tripenyazaraz.noita.engine.Vector;

public abstract class Particle {

    public int x;
    public int y;
    public Vector velocity;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void step(Matrix matrix) {
        move(matrix);
        actToNeighborhood(matrix);
    }

    public void move(Matrix matrix) {}

    public void actToNeighborhood(Matrix matrix) {}

}
