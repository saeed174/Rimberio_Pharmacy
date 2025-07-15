package org.example;

import org.example.Classes.PharmacyEmployee;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class EmployeeDashboard {
    static void employeeDashboardScene(Stage stage, ImageView background , PharmacyEmployee employee) {
        background.setFitWidth(800);
        background.setFitHeight(800);
        background.setPreserveRatio(true);
        background.setOpacity(0.1);
        StackPane sp = new StackPane();
        sp.getChildren().add(background);
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        // Add components to the grid pane for the employee dashboard
        // This is a placeholder for the actual dashboard content
        
        Scene scene = new Scene(sp, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Employee Dashboard");
        stage.show();
    }
}
