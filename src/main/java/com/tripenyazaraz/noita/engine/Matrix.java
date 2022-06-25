package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.Particle;
import com.tripenyazaraz.noita.particle.ParticleFabric;
import com.tripenyazaraz.noita.particle.Particles;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public int height;
    public int width;

    public List<List<Particle>> matrix;

    public Matrix(int height, int width) {
        this.height = height;
        this.width = width;
        generateMatrix();
    }

    private void generateMatrix() {
        matrix = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Particle> innerArray = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                innerArray.add(ParticleFabric.createParticleByName(y, x, Particles.EMPTY));
            }
            matrix.add(innerArray);
        }
    }

    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix.get(y).set(x, ParticleFabric.createParticleByName(y, x, Particles.EMPTY));
            }
        }
    }

    public void step(Vector gravity) {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix.get(y).get(x).step(this);
            }
        }
    }
}
