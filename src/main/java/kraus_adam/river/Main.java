/**
 * Complete the following checklist. If you partially completed an item, put a note how it can be checked for what is working for partial credit.
 *
 *
 * DONE Followed the class OOP diagram
 * DONE Observer pattern (ignores tiers)
 *
 *
 * 1.	Tier: Views and animal
 * DONE a. All objects (ignoring the sim area)
 * DONE b. Have a starting number of tiles in sim area
 * DONE c. Able to add/remove a land area properly
 * DONE d. Info bar listed correctly with all the required elements
 * DONE e. Tile Text correct in land area
 * DONE f. Tile Text correct for each for all rectangles
 * DONE g. Radio buttons update properly
 * DONE h. Selecting a rectangle without “add” updates the land area info
 *
 *
 *
 * 2a Tier: Advanced functionality
 * DONE a. Next month button has some noticeable effect
 * DONE b. Land areas updated properly on “next”
 * DONE c. Sim info bar updated properly
 * DONE d. Selecting a tile after an update shows the new information
 *
 *
 *
 * 2b: Layout
 * DONE a. Location of all items in correct spot
 * DONE b. Layout still correct on window resize
 * DONE c. Resize grid at minimum resets the grid and info
 * DONE d. Everything still working that is listed above with resize
 *
 *
 * Final Tier: Extensions 30
 * Extension 1: 3a 10 points Hotkeys: You can press the Next Month by pressing the keys ALT+N,
 *      the 5X3 resizing with ALT+5, 7X5 with ALT+7, and 9X7 with ALT+9.
 * Extension 2: 3b 15 points Menu Bar: A menu bar is now at the top of the page,
 *      and has a resizing menu, with the same resizing options as in the action commands area.
 * Extension 3: 2d 10 points Land Area Colors: The color of Agriculture land areas is green,
 *      Recreation is red, Flooded is blue, and Unused is grey.
 *
 *
 * The grade you compute is the starting point for course staff, who reserve the right to change the grade if they disagree with your assessment and to deduct points for other issues they may encounter, such as errors in the submission process, naming issues, etc.
 */

package kraus_adam.river;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.Mnemonic;
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
        for (Mnemonic hotkey : view.hotkeys) {
            scene.addMnemonic(hotkey);
        }
        stage.setTitle("River Simulator");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
