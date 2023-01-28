package kraus_adam.river;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        stage.setTitle("River Simulator");
        stage.setScene(scene);
        stage.show();

        Layout.makeContents(root);
    }

    public static void main(String[] args) {
        launch();
    }
}
