/**
 * Complete the following checklist. If you partially completed an item, put a note how it can be checked for what is working for partial credit.
 *
 *
 * ____ Followed the class OOP diagram
 * ____ Observer pattern (ignores tiers)
 *
 *
 * 1.	Tier: Views and animal
 * DONE a. All objects (ignoring the sim area)
 * DONE b. Have a starting number of tiles in sim area
 * ____ c. Able to add/remove a land area properly
 * ____ d. Info bar listed correctly with all the required elements
 * ____ e. Tile Text correct in land area
 * ____ f. Tile Text correct for each for all rectangles
 * ____ g. Radio buttons update properly
 * ____ h. Selecting a rectangle without “add” updates the land area info
 *
 *
 *
 * 2a Tier: Advanced functionality
 * ____ a. Next month button has some noticeable effect
 * ____ b. Land areas updated properly on “next”
 * ____ c. Sim info bar updated properly
 * ____ d. Selecting a tile after an update shows the new information
 *
 *
 *
 * 2b: Layout
 * ____ a. Location of all items in correct spot
 * ____ b. Layout still correct on window resize
 * ____ c. Resize grid at minimum resets the grid and info
 * ____ d. Everything still working that is listed above with resize
 *
 *
 * Final Tier: Extensions 30
 * Extension 1: <number> <points> <name>: <how to test/find if applicable>
 * Extension 2: <number> <points> <name>: <how to test/find if applicable>
 * Etc.
 *
 *
 * The grade you compute is the starting point for course staff, who reserve the right to change the grade if they disagree with your assessment and to deduct points for other issues they may encounter, such as errors in the submission process, naming issues, etc.
 */

package kraus_adam.river;

import javafx.application.Application;
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
