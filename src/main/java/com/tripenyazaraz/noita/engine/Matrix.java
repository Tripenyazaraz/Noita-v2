package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.particle.Particle;
import com.tripenyazaraz.noita.particle.ParticleFabric;
import com.tripenyazaraz.noita.particle.ParticleType;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public int width;
    public int height;

    private List<List<Particle>> matrix;

    public Matrix(int width, int height) {
        this.width = width;
        this.height = height;
        generateMatrix();
    }

    private void generateMatrix() {
        List<List<Particle>> outerArray = new ArrayList<>();
        for (int y = 0; y < height; y++) {
            List<Particle> innerArray = new ArrayList<>();
            for (int x = 0; x < width; x++) {
                innerArray.add(ParticleFabric.createParticleByName(x, y, ParticleType.EMPTY));
            }
            outerArray.add(innerArray);
        }
    }
}
