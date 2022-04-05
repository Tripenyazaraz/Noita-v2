package com.tripenyazaraz.noita.ui;

import com.tripenyazaraz.noita.particle.powder.Sand;
import javafx.application.Application;
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

public class UiApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Noita");
        stage.setScene(createRootScene());
        stage.show();
    }

    private Scene createRootScene() {
        List<ParticleButton> buttons = createButtons();

        VBox sidebar = new VBox();
        sidebar.setSpacing(30);
        sidebar.setAlignment(Pos.TOP_CENTER);
        sidebar.getChildren().addAll(buttons);

        Canvas canvas = new Canvas(FIELD_WIDTH, FIELD_HEIGHT);

        EventHandler<MouseEvent> onMousePressedEventHandler = t -> {
            double x = t.getSceneX();
            double y = t.getSceneY();
            engine.field.putParticle(new Sand(toInt(x), toInt(y)));
        };

        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, onMousePressedEventHandler);

        HBox rootBox = new HBox(canvas, sidebar);
        return new Scene(rootBox);
    }

    private List<ParticleButton> createButtons() {
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