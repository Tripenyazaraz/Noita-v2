package com.tripenyazaraz.noita.engine;

public class Engine extends Thread {

    private Field field;
    private int updateRateInMillis;
    private boolean isOverloaded = false;

    public Engine() {}

    public Engine(int fieldL, int fieldW, int updateRateInMillis) {
        this.field = new Field(fieldL, fieldW);
        this.updateRateInMillis = updateRateInMillis;
    }

    public Field getField() {
        return field;
    }

    public boolean isOverloaded() {
        return isOverloaded;
    }

    @Override
    public void run() {
        if (this.field == null) {
            throw new RuntimeException("Field can not be null!");
        }

        while (!Thread.currentThread().isInterrupted()) {
            long start = System.currentTimeMillis();
            this.field.step();
            long stepTook = System.currentTimeMillis() - start;

            if (stepTook < updateRateInMillis) {
                try {
                    Thread.sleep(updateRateInMillis - stepTook);
                } catch (InterruptedException ignored) {}
                this.isOverloaded = false;
            } else {
                this.isOverloaded = true;
            }
        }
    }

}
