package com.tripenyazaraz.noita.particle.solid;

import com.tripenyazaraz.noita.engine.Field;
import com.tripenyazaraz.noita.particle.AbstractParticle;
import com.tripenyazaraz.noita.particle.Particle;

public abstract class Solid extends AbstractParticle implements Particle {

    public Solid(int x, int y) {
        super(x, y);
    }

    @Override
    public void step(Field field) {}

}
