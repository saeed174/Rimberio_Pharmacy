package org.example;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class StartScene {
    public static void startScene(Stage stage) {
        StackPane sp = new StackPane();

        Image background = new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\logo.png");
        ImageView backgroundView = new ImageView(background);
        backgroundView.setFitWidth(800);
        backgroundView.setFitHeight(800);
        backgroundView.setPreserveRatio(true);
        backgroundView.setOpacity(0.1);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(20);
        gridPane.setVgap(20);

        Image customerImage = new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\customer.jpg");

        ImageView customerView = new ImageView(customerImage);
        customerView.setFitWidth(200);
        customerView.setFitHeight(200);
        customerView.setPreserveRatio(true);
        customerView.setOpacity(0.8);

        Pane imageContainer = new StackPane(customerView);
        imageContainer.setStyle("-fx-border-color: black; -fx-border-width: 4px; -fx-border-radius: 10px;");

        imageContainer.setOnMouseClicked(event -> {
            CustomerLogin.customerLoginScene(stage);
        });

        Label customerLabel = new Label("Customer");
        GridPane.setHalignment(customerLabel, HPos.CENTER);
        GridPane.setValignment(customerLabel, VPos.CENTER);
        customerLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: Black; -fx-padding: 10px; -fx-font-weight: bold;");

        customerLabel.setOnMouseClicked(event -> {
            CustomerLogin.customerLoginScene(stage);
        });


        Image EmployeeImage = new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\Employee.png");

        ImageView employeeView = new ImageView(EmployeeImage);
        employeeView.setFitWidth(200);
        employeeView.setFitHeight(200);
        employeeView.setPreserveRatio(true);
        employeeView.setOpacity(0.8);
        Pane employeeContainer = new StackPane(employeeView);
        employeeContainer.setStyle("-fx-border-color: black; -fx-border-width: 4px; -fx-border-radius: 10px;");

        employeeContainer.setOnMouseClicked(event -> {
            EmployeeLogin.EmployeeLoginScene(stage , backgroundView);
        });

        Label employeeLabel = new Label("Employee");
        GridPane.setHalignment(employeeLabel, HPos.CENTER);
        GridPane.setValignment(employeeLabel, VPos.CENTER);
        employeeLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: Black; -fx-padding: 10px; -fx-font-weight: bold;");

        employeeLabel.setOnMouseClicked(event -> {
            EmployeeLogin.EmployeeLoginScene(stage , backgroundView);
        });

        Label logAsLabel = new Label("Log In As:");
        logAsLabel.setStyle("-fx-font-size: 40px; -fx-text-fill: #1E3A8A; -fx-padding: 5px; -fx-font-weight: bold; -fx-font-family: 'Helvetica';");
        GridPane.setHalignment(logAsLabel, HPos.CENTER);
        GridPane.setValignment(logAsLabel, VPos.CENTER);
        GridPane.setColumnSpan(logAsLabel, 4);

        gridPane.add(imageContainer, 0, 1);
        gridPane.add(employeeContainer, 3, 1);
        gridPane.add(customerLabel, 0, 2);
        gridPane.add(employeeLabel, 3, 2);
        gridPane.add(logAsLabel, 0, 0);

        sp.getChildren().add(backgroundView);
        sp.getChildren().add(gridPane);

        Scene sc = new Scene(sp);
        stage.setTitle("Rimberio Pharmacy");
        
        stage.setWidth(800);
        stage.setHeight(800);
        stage.getIcons().add(new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\logo.png"));
        stage.setScene(sc);
        stage.show();
    }
}
