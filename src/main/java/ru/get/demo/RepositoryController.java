package ru.get.demo;

import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.*;
import java.util.stream.Collectors;

public class RepositoryController {
    @FXML
    private Button closeButton;

    @FXML
    private Button sortButton;

    @FXML
    public ListView<String> userListView;

    public Set<String> users;
    private boolean asc;

    public RepositoryController(Set<String> users) {
        this.users = users;
        userListView.getItems().addAll(users);
        closeButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ((Stage) closeButton.getScene().getWindow()).close();
            }
        });
        sortButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Map<Long, String> map = users.stream()
                        .collect(Collectors.toMap(user -> Long.parseLong(user.split(" ")[2]),
                                user -> user));
                List<Long> list = new ArrayList<>(map.keySet());
                list.sort(Long::compareTo);
                userListView.getItems().clear();
                if (!asc) {
                    Collections.reverse(list);
                }
                userListView.getItems().addAll(FXCollections.observableList(list.stream().map(map::get).toList()));
                asc = !asc;
            }
        });
    }
}
