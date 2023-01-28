package kraus_adam.river;

import kraus_adam.river.Areas.LandArea;
import kraus_adam.river.Areas.Unused;

import java.beans.PropertyChangeSupport;

// subject of observer
public class Tile {
    private PropertyChangeSupport subject;
    private LandArea area;

    public Tile() {
        area = new Unused();
    }

    public void nextMonth() {
        area.nextMonth();
    }
}
