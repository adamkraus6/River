module kraus_adam.river {
    requires javafx.controls;
    requires javafx.fxml;


    opens kraus_adam.river to javafx.fxml;
    exports kraus_adam.river;
    exports kraus_adam.river.Areas;
    opens kraus_adam.river.Areas to javafx.fxml;
}