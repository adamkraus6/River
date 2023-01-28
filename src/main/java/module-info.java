module kraus_adam.river {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens kraus_adam.river to javafx.fxml;
    exports kraus_adam.river;
}