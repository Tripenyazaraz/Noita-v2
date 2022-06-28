package com.tripenyazaraz.noita.logic.particle;

import com.tripenyazaraz.noita.logic.particle.Gas.Steam;
import com.tripenyazaraz.noita.logic.particle.Liquid.Water;
import com.tripenyazaraz.noita.logic.particle.Solid.Immovable.Stone;
import com.tripenyazaraz.noita.logic.particle.Solid.Movable.Sand;
import com.tripenyazaraz.noita.logic.particle.Special.Empty;

public class ParticleFabric {

    public static Particle createParticle(int y, int x, Particles name) {
        Particle particle = null;
        switch (name) {
            case EMPTY -> particle = new Empty(y, x);
            case STEAM -> particle = new Steam(y, x);
            case WATER -> particle = new Water(y, x);
            case STONE -> particle = new Stone(y, x);
            case SAND -> particle = new Sand(y, x);
        }
        assert particle != null;
        return particle;
    }

}
