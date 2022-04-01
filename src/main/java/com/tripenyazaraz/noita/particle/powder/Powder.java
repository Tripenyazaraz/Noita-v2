package com.tripenyazaraz.noita.particle.powder;

import com.tripenyazaraz.noita.engine.Field;
import com.tripenyazaraz.noita.particle.AbstractMovable;
import com.tripenyazaraz.noita.particle.Coords;
import com.tripenyazaraz.noita.particle.Particle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Powder extends AbstractMovable implements Particle {

    public Powder(int x, int y) {
        super(x, y);
    }

    @Override
    public void step(Field field) {
        List<Coords> order = makeOrder();
        super.step(field, order);
    }

    private List<Coords> makeOrder() {
        Random rnd = new Random();
        int lr = rnd.nextBoolean() ? -1 : 1;
        List<Coords> order = new ArrayList<>();

        order.add(new Coords(0, -1));
        order.add(new Coords(lr, -1));
        order.add(new Coords(lr * -1, -1));

        return order;
    }

}
