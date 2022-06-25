package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.engine.Matrix;
import com.tripenyazaraz.noita.engine.Vector;

public abstract class Particle {

    public int y;
    public int x;
    public Vector velocity;

    public Particle(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public void step(Matrix matrix) {
        move(matrix);
        actToNeighborhood(matrix);
    }

    public void move(Matrix matrix) {}

    public void actToNeighborhood(Matrix matrix) {}

}
