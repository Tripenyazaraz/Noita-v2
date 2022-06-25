package com.tripenyazaraz.noita.particle;

public abstract class Particle {

    int x;
    int y;

    public Particle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void step() {
        move();
        actToNeighborhood();
    }

    public void move() {}

    public void actToNeighborhood() {}

}
