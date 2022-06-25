package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.GConst;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Engine extends Thread {

    public Matrix matrix;
    public Vector gravity;

    public long stepRateInMillis;
    public boolean isOverloaded = false;

    public Engine() {
        this.configure();
    }

    @Override
    public void run() {

        long stepStartMillis;
        long stepMillis;

        while (!Thread.currentThread().isInterrupted()) {
            try {
                stepStartMillis = System.currentTimeMillis();

                this.matrix.step(gravity);

                stepMillis = System.currentTimeMillis() - stepStartMillis;
                this.isOverloaded = stepMillis < stepRateInMillis;
                if (!isOverloaded) {
                    Thread.sleep(stepRateInMillis - stepMillis);
                }
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public void configure() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(GConst.PROPERTIES_FILE_PATH));

            this.matrix = new Matrix(
                    Integer.parseInt(properties.getProperty("matrix.height")),
                    Integer.parseInt(properties.getProperty("matrix.width"))
            );
            this.gravity = new Vector(
                    Float.parseFloat(properties.getProperty("engine.gravity.y")),
                    Float.parseFloat(properties.getProperty("engine.gravity.x"))
            );
            this.stepRateInMillis = Integer.parseInt(properties.getProperty("engine.stepRateInMillis"));

        } catch (IOException e) {
            throw new RuntimeException("Can not find properties file!");

        } catch (NumberFormatException e) {
            throw new RuntimeException("Something went wrong while configure engine! You should check your properties file! Exact exception -> " + e.getMessage());
        }
    }

}
