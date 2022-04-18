package com.tripenyazaraz.noita;

import com.tripenyazaraz.noita.engine.Engine;
import javafx.application.Application;
import javafx.stage.Stage;

import static com.tripenyazaraz.noita.Context.engine;

public class NoitaApp extends Application {

    public static void main(String[] args) {
        // ToDo везде заменить THREAD на TIMER
        // Engine part
        engine = new Engine();
        engine.field.clearAll();

        // Ui part
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage.show();
    }
}