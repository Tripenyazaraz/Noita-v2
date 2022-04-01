package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.engine.Field;
import com.tripenyazaraz.noita.engine.Engine;
import com.tripenyazaraz.noita.particle.special.Void;

import java.util.List;

public abstract class AbstractMovable extends AbstractParticle implements Particle {

    private int velocity;

    public AbstractMovable(int x, int y) {
        super(x, y);
        this.setVelocity(1);
    }

    public AbstractMovable(int x, int y, int velocity) {
        super(x, y);
        this.setVelocity(velocity);
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public void move(int dirX, int dirY) {
        Void v = new Void(this.getX(), this.getY());
        this.setX(this.getX() + dirX * this.getVelocity());
        this.setY(this.getY() + dirY * this.getVelocity());
        Engine.field.putParticle(this);
        Engine.field.putParticle(v);
    }

    public void step(Field field, List<Coords> order) {
        for (Coords coord : order) {
            if (field.isEmpty(this.getX() + coord.x, this.getY() + coord.y)) {
                this.move(coord.x, coord.y);
                break;
            }
        }
    }

}
