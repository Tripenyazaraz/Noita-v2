package com.tripenyazaraz.noita.particle.special;

import com.tripenyazaraz.noita.engine.Field;
import com.tripenyazaraz.noita.particle.AbstractParticle;
import com.tripenyazaraz.noita.particle.Particle;

public class Void extends AbstractParticle implements Particle {

    public Void(int x, int y) {
        super(x, y);
    }

    @Override
    public void step(Field field) {}

}
