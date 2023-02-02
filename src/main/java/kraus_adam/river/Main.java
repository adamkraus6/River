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
        RiverSim model = new RiverSim(5, 3);
        Layout view = new Layout(model);
        Controller controller = new Controller(model, view);
        Scene scene = new Scene(view.root, WIDTH, HEIGHT);
        stage.setTitle("River Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
