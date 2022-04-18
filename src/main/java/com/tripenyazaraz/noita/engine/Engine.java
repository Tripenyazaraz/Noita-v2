package com.tripenyazaraz.noita.engine;

import static com.tripenyazaraz.noita.Const.*;

public class Engine {

    public Field field;

    public Engine() {
        this.field = new Field(FIELD_WIDTH, FIELD_HEIGHT);
        PhysicsThread physicsThread = new PhysicsThread(1000);
        physicsThread.start();
    }

}

