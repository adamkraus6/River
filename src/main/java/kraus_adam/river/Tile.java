package kraus_adam.river;

import kraus_adam.river.Areas.LandArea;
import kraus_adam.river.Areas.Unused;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// subject of observer
public class Tile {
    private PropertyChangeSupport subject;
    private LandArea area;

    public Tile() {
        area = new Unused(0);
        subject = new PropertyChangeSupport(this);
    }

    public String getDetails() {
        return area.getDetails();
    }

    public String getMonthlyChange() {
        return area.getMonthlyChange();
    }

    public int nextMonth() {
        int money = area.nextMonth();
        subject.firePropertyChange("nextMonth", null, null);
        return money;
    }

    public void addObserver(PropertyChangeListener obs) {
        // GRADING: SUBJECT
        subject.addPropertyChangeListener(obs);
    }

    public String getColor() {
        return area.getColor();
    }

    public String getName() {
        return area.getName();
    }

    public void setTile(LandArea area) {
        this.area = area;
        // GRADING: TRIGGER
        subject.firePropertyChange("change", null, null);
    }
}
