package ru.get.demo;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

public class HelloApplication extends Application {
    Set<String> users = new HashSet<>();

    @FXML
    Label lb_name_full;

    @FXML
    TextField a1;

    @FXML
    TextField a2;

    @FXML
    Button c1;
    @FXML
    Label lbl_name;
    @FXML  Label lbl_lastname;

    @FXML
    AnchorPane pane;

    @FXML
    private Button reposotoryButton;

    @FXML
    private Button closeButton;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        fxmlLoader.setController(this);
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        c1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                lb_name_full.setText(a1.getText() + " " + a2.getText());
                long time = System.currentTimeMillis();
                users.add(a1.getText() + " " + a2.getText() + " " + time);
            }
        });
        reposotoryButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("repository-view.fxml"));
                RepositoryController repositoryController = new RepositoryController(users);
                fxmlLoader.setController(repositoryController);
                try {
                    Scene scene1 = new Scene(fxmlLoader.load());
                    Stage stage1 = new Stage();
                    stage1.setScene(scene1);
                    stage1.showAndWait();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        for (int i = 0; i < pane.getChildren().size(); i++) {
            if (pane.getChildren().get(i) instanceof Label label) {
                label.setFont(new Font(10));
            }
        }
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}