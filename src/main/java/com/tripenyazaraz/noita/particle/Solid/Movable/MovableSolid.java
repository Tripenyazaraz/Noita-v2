package com.tripenyazaraz.noita.particle.Solid.Movable;

import com.tripenyazaraz.noita.engine.Matrix;
import com.tripenyazaraz.noita.engine.Vector;
import com.tripenyazaraz.noita.particle.Particle;

import java.util.SplittableRandom;

public abstract class MovableSolid extends Particle {
    SplittableRandom r = new SplittableRandom();

    public MovableSolid(int y, int x) {
        super(y, x);
    }

    @Override
    public Vector getActualVelocity(Matrix matrix) {
        Vector actualVelocity = this.velocity.plus(matrix.gravity);
        if (actualVelocity.x == 0 && actualVelocity.y != 0) {
            actualVelocity.addX(r.nextBoolean() ? 0.1f : -0.1f);
        }
        return actualVelocity;
    }

}
