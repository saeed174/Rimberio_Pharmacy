package org.example;

import org.example.Classes.PharmacyEmployee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.persistence.Query;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class EmployeeLogin {
    public static void EmployeeLoginScene(Stage stage , ImageView background) {
        StackPane sp = new StackPane();
        sp.getChildren().add(background);
        
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        Image EmployeeImage = new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\Employee.png");
        
        ImageView employeeView = new ImageView(EmployeeImage);
        employeeView.setFitWidth(200);
        employeeView.setFitHeight(200);
        employeeView.setPreserveRatio(true);
        employeeView.setOpacity(0.8);
        Pane employeeContainer = new StackPane(employeeView);
        employeeContainer.setStyle("-fx-border-color: black; -fx-border-width: 4px; -fx-border-radius: 10px;");
        GridPane.setColumnSpan(employeeContainer, 2);
        gridPane.add(employeeContainer, 0, 0);
        
        Text title = new Text("Employee Login");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: black;");
        title.setTextAlignment(TextAlignment.CENTER);
        GridPane.setHalignment(title, HPos.CENTER);
        GridPane.setValignment(title, VPos.CENTER);

        GridPane.setColumnSpan(title, 2);
        gridPane.add(title, 0, 1);

        Text emailLabel = new Text("Email:");
        emailLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black; -fx-font-weight: bold;");
        gridPane.add(emailLabel, 0, 2);

        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        gridPane.add(emailField, 1, 2);

        Text passwordLabel = new Text("Password:");
        passwordLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: black; -fx-font-weight: bold;");
        gridPane.add(passwordLabel, 0, 3);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");

        TextField visiblePasswordField = new TextField();
        visiblePasswordField.setPromptText("Enter your password");
        visiblePasswordField.setVisible(false);
        visiblePasswordField.setManaged(false);

        visiblePasswordField.textProperty().bindBidirectional(passwordField.textProperty());

        gridPane.add(passwordField, 1, 3);
        gridPane.add(visiblePasswordField, 1, 3);

        CheckBox showPassword = new CheckBox("Show Password");
        gridPane.add(showPassword, 2, 3);

        showPassword.setOnAction(event -> {
            boolean show = showPassword.isSelected();
            passwordField.setVisible(!show);
            passwordField.setManaged(!show);
            visiblePasswordField.setVisible(show);
            visiblePasswordField.setManaged(show);
        });
        
        Label messageLabel = new Label();
        messageLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: red; -fx-font-weight: bold;");
        GridPane.setHalignment(messageLabel, HPos.CENTER);
        GridPane.setValignment(messageLabel, VPos.CENTER);
        GridPane.setColumnSpan(messageLabel, 2);
        gridPane.add(messageLabel, 0, 5);

        Button loginButton = new Button("Sign in");
        loginButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-background-color: #1E3A8A;" +
            "-fx-text-fill: white;" +
            "-fx-border-color: black;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 5px;" +
            "-fx-padding: 5 15 5 15;" +
            "-fx-cursor: hand;" +
            "-fx-font-weight: bold;"
        );
        gridPane.add(loginButton, 0, 4);
        loginButton.setOnAction(event -> {
            signUp(stage,emailField.getText(), passwordField.getText(), messageLabel);
        });


        Button signUpButton = new Button("Sign Up");
        signUpButton.setStyle(
            "-fx-font-size: 18px;" +
            "-fx-background-color: #1E3A8A;" +
            "-fx-text-fill: white;" +
            "-fx-border-color: black;" +
            "-fx-border-width: 2px;" +
            "-fx-border-radius: 5px;" +
            "-fx-padding: 5 15 5 15;" +
            "-fx-cursor: hand;" +
            "-fx-font-weight: bold;"
        );
        gridPane.add(signUpButton, 1, 4);
        signUpButton.setOnAction(event -> {
            System.out.println("Sign Up button clicked");
        });


        Button backButton = new Button("←");
        StackPane.setAlignment(backButton, Pos.TOP_LEFT);
        backButton.setStyle(
            "-fx-font-size: 30px;" +
            "-fx-background-color: transparent;" +
            "-fx-text-fill: black;" +
            "-fx-border-color: black;" +
            "-fx-border-width: 2px;" +
            "-fx-font-weight: bold;" +
            "-fx-border-radius: 5px;" +
            "-fx-padding: 5 15 5 15;" +
            "-fx-cursor: hand;" +
            "-fx-font-weight: bold;"
        );
        backButton.setOnAction(event -> {
            StartScene.startScene(stage);
        });

        sp.getChildren().add(gridPane);
        sp.getChildren().add(backButton);

        Scene sc = new Scene(sp);
        sc.setOnKeyPressed(eh -> {
            if (eh.getCode().toString().equals("ENTER")) {
                signUp(stage,emailField.getText(), passwordField.getText(), messageLabel);
            }
        });
        stage.setScene(sc);
        stage.show();
    }

    static void signUp(Stage stage , String email, String password , Label messageLabel) {
        // Logic for signing up the employee
        // This is a placeholder for actual sign-up logic
        if (email.isEmpty() || password.isEmpty()) {
            messageLabel.setText("Email and Password cannot be empty.");
        } else if(!email.contains("@Pharmacy.com")) {
            messageLabel.setText("Email must be a valid Pharmacy email.");
        } else {
            messageLabel.setText("Checking employee......");
            SessionFactory sf = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(org.example.Classes.PharmacyEmployee.class)
                .buildSessionFactory();

            Session session = sf.openSession();
            String correctPass = "";
            try {
                session.beginTransaction();
                Query query = session.createQuery("from PharmacyEmployee where email = :email");
                query.setParameter("email", email);
                PharmacyEmployee existingEmployee = null;
                try {
                    existingEmployee = (PharmacyEmployee) query.getSingleResult();
                    correctPass = existingEmployee.getName() + existingEmployee.getId();
                } catch (jakarta.persistence.NoResultException ex) {
                    existingEmployee = null;
                }

                if(existingEmployee == null)
                {
                    messageLabel.setText("Employee does not exist\tPlease sign up first.");

                }
                else if (correctPass.equals(password)) {
                    // TODO : Handle successful login
                    EmployeeDashboard.employeeDashboardScene(stage, new ImageView(new Image("File:D:\\Summer2025\\Rimberio_Pharmacy\\Pharmacy\\src\\main\\java\\org\\example\\logo.png")) , existingEmployee);
                } else {
                    messageLabel.setText("Incorrect password. Please try again.");
                }
            } catch (Exception e) {
                e.printStackTrace();
                messageLabel.setText("An error occurred while checking the employee.");
            } finally {
                session.getTransaction().commit();
                session.close();
                sf.close();
            }

        }
    }
}
