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

    /**
     * Forwards getDetails to land area
     * 
     * @return String
     */
    public String getDetails() {
        return area.getDetails();
    }

    /**
     * Forwards getMonthlyChange to land area
     * 
     * @return String
     */
    public String getMonthlyChange() {
        return area.getMonthlyChange();
    }

    /**
     * Forwards nextMonth to land area and notifies observers
     * 
     * @return int monthly money change
     */
    public int nextMonth() {
        int money = area.nextMonth();
        // GRADING: TRIGGER
        subject.firePropertyChange("nextMonth", null, null);
        return money;
    }

    /**
     * Attaches an observer
     * 
     * @param obs Observer
     */
    public void addObserver(PropertyChangeListener obs) {
        // GRADING: SUBJECT
        subject.addPropertyChangeListener(obs);
    }

    /**
     * Forwards getColor to land area
     * 
     * @return String
     */
    public String getColor() {
        return area.getColor();
    }

    /**
     * Forwards getName to land area
     * 
     * @return String
     */
    public String getName() {
        return area.getName();
    }

    /**
     * Sets a new land area and notifies observer
     * 
     * @param area New land area
     */
    public void setTile(LandArea area) {
        this.area = area;
        // GRADING: TRIGGER
        subject.firePropertyChange("change", null, null);
    }
}
