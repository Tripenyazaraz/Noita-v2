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

    public void move(Matrix matrix) {
        Vector actualVelocity = getActualVelocity(matrix);

        int moveToY = this.y + Math.round(actualVelocity.y);
        int moveToX = this.x + Math.round(actualVelocity.x);
        if (matrix.isInBounds(moveToY, moveToX)) {
            this.moveTo(moveToY, moveToX, matrix);
        }
    }

    public Vector getActualVelocity(Matrix matrix) {
        return new Vector(0, 0);
    }

    public void actToNeighborhood(Matrix matrix) {}

    public void moveTo(int y, int x, Matrix matrix) {
        matrix.set(y, x, this);
        matrix.set(this.y, this.x, ParticleFabric.createParticle(this.y, this.x, Particles.EMPTY));
        this.y = y;
        this.x = x;
    }

    public void swapWith(Particle particle, Matrix matrix) {
        matrix.set(particle.y, particle.x, this);
        matrix.set(this.y, this.x, particle);
        int _y = this.y;
        int _x = this.x;
        this.y = particle.y;
        this.x = particle.x;
        particle.y = _y;
        particle.x = _x;
    }

}
