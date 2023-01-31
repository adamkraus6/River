package kraus_adam.river;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

// observer
public class TileView extends Button implements PropertyChangeListener {
    public TileView() {
        setTextAlignment(TextAlignment.CENTER);
        setText("-U-\n-$0k\n+$0k");
    }
    @Override
    public void propertyChange(PropertyChangeEvent event) {

    }
}
