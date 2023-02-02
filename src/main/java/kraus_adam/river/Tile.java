package kraus_adam.river;

import kraus_adam.river.Areas.Agriculture;
import kraus_adam.river.Areas.LandArea;
import kraus_adam.river.Areas.Recreation;
import kraus_adam.river.Areas.Unused;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// subject of observer
public class Tile {
    private PropertyChangeSupport subject;
    private LandArea area;

    public Tile() {
        area = new Unused();
        subject = new PropertyChangeSupport(this);
    }

    public void nextMonth() {
        area.nextMonth();
        subject.firePropertyChange("rev", null, null);
    }

    public void addObserver(PropertyChangeListener obs) {
        // GRADING: SUBJECT
        subject.addPropertyChangeListener(obs);
    }

    public String getName() {
        return area.getName();
    }

    public int getCost() {
        return area.getCost();
    }

    public int getRev() {
        return area.getRev();
    }

    public void setTile(String selected) {
        switch(selected) {
            case "Agriculture":
                area = new Agriculture();
                break;
            case "Recreation":
                area = new Recreation();
                break;
            case "Unused":
                area = new Unused();
                break;
        }
        // GRADING: TRIGGER
        subject.firePropertyChange("change", null, null);
    }
}
