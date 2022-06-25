package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.Particle;
import com.tripenyazaraz.noita.particle.ParticleFabric;
import com.tripenyazaraz.noita.particle.Particles;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public int width;
    public int height;

    public List<List<Particle>> matrix;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        generateMatrix();
    }

    private void generateMatrix() {
        matrix = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Particle> innerArray = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                innerArray.add(ParticleFabric.createParticleByName(x, y, Particles.EMPTY));
            }
            matrix.add(innerArray);
        }
    }

    public void clear() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                matrix.get(y).set(x, ParticleFabric.createParticleByName(x, y, Particles.EMPTY));
            }
        }
    }
}
