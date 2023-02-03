package kraus_adam.river;

import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// observer
public class TileView extends Button implements PropertyChangeListener {
    private Tile tile;

    public TileView() {
        setTextAlignment(TextAlignment.CENTER);
    }

    public void setModel(Tile tile) {
        this.tile = tile;
        getTile();
    }

    private void getTile() {
        String name = tile.getName();
        String monthly = tile.getMonthlyChange();
        setText("-" + name.charAt(0) + "-\n" + monthly);
        setStyle("-fx-background-color: " + tile.getColor());
    }

    public String getTileDetails() {
        String name = tile.getDetails();
        return name;
    }

    // GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        getTile();
    }
}
