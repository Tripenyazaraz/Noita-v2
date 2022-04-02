package com.tripenyazaraz.noita;

import com.tripenyazaraz.noita.engine.Engine;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class NoitaController {

    @FXML
    private Canvas canvas;

    @FXML
    protected void onCanvasPressed() {
        GraphicsContext gc =  canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, Engine.FIELD_HEIGHT, Engine.FIELD_HEIGHT);
    }

    @FXML
    protected void onCanvasReleased() {
        GraphicsContext gc =  canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, Engine.FIELD_HEIGHT, Engine.FIELD_HEIGHT);
    }
}