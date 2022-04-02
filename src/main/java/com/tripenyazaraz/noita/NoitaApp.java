package com.tripenyazaraz.noita;

import com.tripenyazaraz.noita.engine.Engine;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NoitaApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NoitaApp.class.getResource("noita.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), Engine.FIELD_WIDTH, Engine.FIELD_HEIGHT);
        stage.setTitle("Noita");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
//        Engine engine = new Engine();
    }
}