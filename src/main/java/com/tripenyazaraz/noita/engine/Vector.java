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

    public void addX(float x) {
        this.x += x;
    }

    public void addY(float y) {
        this.y += y;
    }

    public Vector plus(Vector v) {
        return new Vector(
                this.y + v.y,
                this.x + v.x
        );
    }

    public Vector plusX(float x) {
        return new Vector(
                this.y,
                this.x + x
        );
    }

    public Vector plusY(float y) {
        return new Vector(
                this.y + y,
                this.x
        );
    }

    public Vector getInverted() {
        return new Vector(
                this.y * -1,
                this.x * -1
        );
    }

}
