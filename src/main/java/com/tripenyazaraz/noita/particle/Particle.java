package com.tripenyazaraz.noita.particle;

import com.tripenyazaraz.noita.engine.Field;

public interface Particle {

    int getX();

    void setX(int x);

    int getY();

    void setY(int y);

    void step(Field field);

}
