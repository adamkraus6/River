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
        pullTile();
    }

    private void pullTile() {
        String name = tile.getName();
        setText("-" + name.charAt(0) + "-\n-$0k\n+$0k");
    }

    // GRADING: OBSERVE
    @Override
    public void propertyChange(PropertyChangeEvent event) {
        pullTile();
    }
}
