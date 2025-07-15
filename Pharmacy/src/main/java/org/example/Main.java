package org.example;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        StartScene.startScene(stage);
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }
}