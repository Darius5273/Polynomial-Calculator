package com.example.pt2024_30423_cornoc_dariusandrei_assignment_1.Graphical_user_interface;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/pt2024_30423_cornoc_dariusandrei_assignment_1/polynomial-interface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Polynomial Calculator!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

