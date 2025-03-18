package ru.get.demo;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class RepositoryController {
    @FXML
    private Button closeButton;

    @FXML
    public ListView<String> userListView;

    public RepositoryController(List<String> users) {
        closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ((Stage)closeButton.getScene().getWindow()).close();
            }
        });
        userListView.getItems().addAll(users);
    }
}