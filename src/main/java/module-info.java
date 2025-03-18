module ru.get.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.get.demo to javafx.fxml;
    exports ru.get.demo;
}