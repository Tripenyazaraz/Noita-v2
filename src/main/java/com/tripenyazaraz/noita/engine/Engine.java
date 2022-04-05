package com.tripenyazaraz.noita.engine;

import static com.tripenyazaraz.noita.Context.*;

public class Engine {

    public Field field;

    public Engine() {
        this.field = new Field(FIELD_WIDTH, FIELD_HEIGHT);
        field.clearAll();
        PhysicsThread physicsThread = new PhysicsThread(1000);
        physicsThread.start();
    }

}

