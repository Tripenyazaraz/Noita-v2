package com.tripenyazaraz.noita;


import com.tripenyazaraz.noita.engine.Engine;
import com.tripenyazaraz.noita.ui.UiUtils;
import javafx.application.Application;
import javafx.stage.Stage;

public class NoitaApp extends Application {

    public static void main(String[] args) {
        // Engine part
        Context.engine = new Engine();

        // Ui part
        launch();
    }

    @Override
    public void start(Stage stage) {
        stage = UiUtils.createUi(stage);
        stage.show();
    }
}