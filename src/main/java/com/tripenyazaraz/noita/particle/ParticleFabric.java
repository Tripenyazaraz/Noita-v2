package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.particle.Gas.Steam;
import com.tripenyazaraz.noita.particle.Liquid.Water;
import com.tripenyazaraz.noita.particle.Solid.Immovable.Stone;
import com.tripenyazaraz.noita.particle.Solid.Movable.Sand;
import com.tripenyazaraz.noita.particle.Special.Empty;

public class ParticleFabric {

    public static Particle createParticleByName(int x, int y, Particles name) {
        Particle particle = null;
        switch (name) {
            case EMPTY -> particle = new Empty(x, y);
            case STEAM -> particle = new Steam(x, y);
            case WATER -> particle = new Water(x, y);
            case STONE -> particle = new Stone(x, y);
            case SAND -> particle = new Sand(x, y);
        }
        assert particle != null;
        return particle;
    }

}
