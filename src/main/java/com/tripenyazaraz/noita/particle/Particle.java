package com.tripenyazaraz.noita.particle;

public abstract class Particle {

    public void step() {
        move();
        actToNeighborhood();
    }

    public void move() {}

    public void actToNeighborhood() {}

}
