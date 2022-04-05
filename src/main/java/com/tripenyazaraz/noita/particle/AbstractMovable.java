package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.engine.Field;
import com.tripenyazaraz.noita.particle.special.Void;

import java.util.List;

import static com.tripenyazaraz.noita.Context.*;

public abstract class AbstractMovable extends AbstractParticle implements Particle {

    public int velocity;

    public AbstractMovable(int x, int y) {
        super(x, y);
        this.velocity = 1;
    }

    public AbstractMovable(int x, int y, int velocity) {
        super(x, y);
        this.velocity = velocity;
    }

    public void move(int dirX, int dirY) {
        Void v = new Void(this.getX(), this.getY());
        this.setX(this.getX() + dirX * this.velocity);
        this.setY(this.getY() + dirY * this.velocity);
        engine.field.putParticle(this);
        engine.field.putParticle(v);
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
