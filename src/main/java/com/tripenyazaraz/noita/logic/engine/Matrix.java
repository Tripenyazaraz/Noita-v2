package com.tripenyazaraz.noita.logic.engine;

import com.tripenyazaraz.noita.logic.particle.Particle;
import com.tripenyazaraz.noita.logic.particle.ParticleFabric;
import com.tripenyazaraz.noita.logic.particle.Particles;
import com.tripenyazaraz.noita.logic.particle.Special.Empty;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public int height;
    public int width;
    public Vector gravity;

    public List<List<Particle>> matrix;

    public Matrix(int height, int width, Vector gravity) {
        this.height = height;
        this.width = width;
        this.gravity = gravity;
        generateMatrix();
    }

    private void generateMatrix() {
        matrix = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Particle> innerArray = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                innerArray.add(ParticleFabric.createParticle(y, x, Particles.EMPTY));
            }
            matrix.add(innerArray);
        }
    }

    public boolean isInBounds(int y, int x) {
        return y >= 0 && y < height && x >=0 && x < width;
    }

    public void step() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                this.get(y, x).step(this);
            }
        }
    }

    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix.get(y).set(x, ParticleFabric.createParticle(y, x, Particles.EMPTY));
            }
        }
    }

    public Particle get(int y, int x) {
        if (isInBounds(y, x)) {
            return matrix.get(y).get(x);
        } else {
            throw new RuntimeException("coordinates out of bounds!");
        }
    }

    public void set(int y, int x, Particle particle) {
        if (isInBounds(y, x)) {
            matrix.get(y).set(x, particle);
        } else {
            throw new RuntimeException("coordinates out of bounds!");
        }
    }

    public boolean isEmpty(int y, int x) {
        return isInBounds(y, x) && matrix.get(y).get(x) instanceof Empty;
    }

}
