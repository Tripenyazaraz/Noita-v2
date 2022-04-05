package com.tripenyazaraz.noita.ui;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static com.tripenyazaraz.noita.Context.*;
import static com.tripenyazaraz.noita.Utils.*;

public class UiUtils {

    public static Stage createUi(Stage stage) {
        stage.setTitle("Noita");
        stage.setScene(createRootScene());
        return stage;
    }

    private static Scene createRootScene() {
        // Create particle buttons
        List<ParticleButton> buttons = createButtons();

        // create sidebar and fill it with buttons
        VBox sidebar = new VBox();
        sidebar.setSpacing(30);
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.getChildren().addAll(buttons);

        // create canvas
        Canvas canvas = new Canvas(FIELD_WIDTH, FIELD_HEIGHT);

        // add mouse handlers to canvas
        MouseThread mouseListener = new MouseThread(10);
            // anytime it listen to current mouse position
        EventHandler<MouseEvent> any = t -> {
            mouseListener.x = toInt(t.getSceneX());
            mouseListener.y = toInt(t.getSceneY());
        };
            // on click, it starts particle summon thread
        EventHandler<MouseEvent> startSummonHandler = t -> {
            mouseListener.release();
        };
            // on release, it stops particle summon thread
        EventHandler<MouseEvent> stopSummonHandler = t -> {
            mouseListener.pause();
        };
        canvas.addEventHandler(MouseEvent.ANY, any);
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, startSummonHandler);
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, stopSummonHandler);
        mouseListener.start();

        HBox rootBox = new HBox(canvas, sidebar);
        return new Scene(rootBox);
    }

    private static List<ParticleButton> createButtons() {
        try {
            Path path = Path.of("data/particles");
            List<String> lines = Files.readAllLines(path);
            List<ParticleButton> buttons = new ArrayList<>();
            for (String str : lines){
                buttons.add(new ParticleButton(str));
            }
            return buttons;
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }
}
