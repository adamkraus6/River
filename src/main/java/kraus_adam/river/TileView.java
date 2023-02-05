package kraus_adam.river;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// observer
public class TileView extends Button implements PropertyChangeListener {
    private Tile tile;

    /**
     * TileView constructor
     */
    public TileView() {
        setTextAlignment(TextAlignment.CENTER);
    }

    /**
     * Sets the model to reference
     * 
     * @param tile Tile in RiverSim model
     */
    public void setModel(Tile tile) {
        this.tile = tile;
        tile.addObserver(this);
        getTile();
    }

    /**
     * Sets the Button text with current monthly information from tile
     */
    private void getTile() {
        String name = tile.getName();
        String monthly = tile.getMonthlyChange();
        setText("-" + name.charAt(0) + "-\n" + monthly);
        setStyle("-fx-background-color: " + tile.getColor());
    }

    /**
     * Gets the detailed tile information for the land area section
     * 
     * @return String Detailed tile information
     */
    public String getTileDetails() {
        String name = tile.getDetails();
        return name;
    }

    /**
     * Runs whenever observer is notified
     * 
     * @param event ActionEvent
     */
    // GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        getTile();
    }
}
