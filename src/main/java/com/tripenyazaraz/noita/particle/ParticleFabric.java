package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.particle.Gas.Steam;
import com.tripenyazaraz.noita.particle.Liquid.Water;
import com.tripenyazaraz.noita.particle.Solid.Immovable.Stone;
import com.tripenyazaraz.noita.particle.Solid.Movable.Sand;
import com.tripenyazaraz.noita.particle.Special.Empty;

public class ParticleFabric {

    public static Particle createParticleByName(int y, int x, Particles name) {
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
