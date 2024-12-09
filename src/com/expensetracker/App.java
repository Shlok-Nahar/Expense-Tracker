package com.expensetracker;

import java.util.logging.Logger;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) {

        Logger logger = Logger.getLogger(getClass().getName());

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(event -> logger.info("Hello World!"));

        StackPane root = new StackPane();
        root.getChildren().add(btn);

        /*
        Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
        Scene scene = new Scene(root);
        */

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
