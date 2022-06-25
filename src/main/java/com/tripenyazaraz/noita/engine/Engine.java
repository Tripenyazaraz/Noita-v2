package com.tripenyazaraz.noita.engine;

import com.tripenyazaraz.noita.GConst;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Engine extends Thread {

    public Matrix matrix;
    public Vector gravity;

    public long stepTimeOut;
    public boolean isOverloaded = false;

    public Engine() {}

    @Override
    public void run() {

        this.configure();

        long stepStartTime;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                stepStartTime = System.currentTimeMillis();

                // logic

                long stepTime = System.currentTimeMillis() - stepStartTime;
                if (stepTime < stepTimeOut) {
                    Thread.sleep(stepTimeOut - stepTime);
                    this.isOverloaded = false;
                } else {
                    this.isOverloaded = true;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void configure() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream(GConst.PROPERTIES_FILE_PATH));

            this.matrix = new Matrix(
                    Integer.parseInt(properties.getProperty("matrix.width")),
                    Integer.parseInt(properties.getProperty("matrix.height"))
            );
            this.gravity = new Vector(
                    Float.parseFloat(properties.getProperty("gravity.x")),
                    Float.parseFloat(properties.getProperty("gravity.y"))
            );
            this.stepTimeOut = Integer.parseInt(properties.getProperty("stepTimeOut"));

        } catch (IOException e) {
            throw new RuntimeException("Can not find properties file!");

        } catch (NumberFormatException e) {
            throw new RuntimeException("Something went wrong while configure engine! You should check your properties file! Exact exception -> " + e.getMessage());
        }
    }

}
