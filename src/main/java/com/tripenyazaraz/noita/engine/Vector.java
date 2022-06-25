package com.tripenyazaraz.noita.engine;

public class Vector {

    public float x;
    public float y;

    public Vector(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector v) {
        this.x += v.x;
        this.y += v.y;
    }

    public Vector getInverted() {
        return new Vector(this.x * -1, this.y * -1);
    }

}
