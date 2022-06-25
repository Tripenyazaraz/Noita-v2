package com.tripenyazaraz.noita.engine;

public class Engine {

    public Vector gravity;
    public Matrix matrix;

    public Engine() {
        // ToDo вынести поля в настройки
        this.gravity = new Vector(0f, 1f);
        this.matrix = new Matrix(100, 100);
    }

}
