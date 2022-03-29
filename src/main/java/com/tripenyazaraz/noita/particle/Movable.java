package com.tripenyazaraz.noita.particle;

public abstract class Movable extends AbstractParticle {

    public class Vector2 {

        private final int x;
        private final int y;

        public Vector2(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Vector2 plus(Vector2 other) {
            return new Vector2(x + other.x, y + other.y);
        }

    }

    private Vector2 vector;

    private int velocity;

    public Movable(int x, int y) {
        super(x, y);
        this.velocity = 0;
        this.vector = new Vector2(0, 0);
    }

    public Vector2 getVector() {
        return vector;
    }

    public void setVector(Vector2 vector) {
        this.vector = vector;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

}
