package com.tripenyazaraz.noita;


import com.tripenyazaraz.noita.ui.UiApp;
import javafx.stage.Stage;

public class NoitaApp {

    public static void main(String[] args) {
        start();
    }

    public static void start() {
        UiApp app = new UiApp();
        app.start(new Stage());
    }

}