package com.tripenyazaraz.noita.engine;

public class Engine {

    private final Field field;

    public Field getField() {
        return field;
    }

    public Engine() {
        this.field = new Field(100, 100);
    }

}

