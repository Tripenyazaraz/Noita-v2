package com.tripenyazaraz.noita.particle;

import static com.tripenyazaraz.noita.Context.engine;

public abstract class AbstractParticle implements Particle {

    public int x;

    public int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public AbstractParticle(int x, int y) {
        this.x = x;
        this.y = y;
        engine.field.putParticle(this);
    }

}
