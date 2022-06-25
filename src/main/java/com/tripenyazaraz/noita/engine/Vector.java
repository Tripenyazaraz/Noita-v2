package com.tripenyazaraz.noita.engine;

public class Vector {

    public float y;
    public float x;

    public Vector(float y, float x) {
        this.y = y;
        this.x = x;
    }

    public void add(Vector v) {
        this.y += v.y;
        this.x += v.x;
    }

    public Vector getInverted() {
        return new Vector(this.y * -1, this.x * -1);
    }

}
