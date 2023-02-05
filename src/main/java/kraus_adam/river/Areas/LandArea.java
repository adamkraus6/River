package kraus_adam.river.Areas;

public class LandArea {
    protected int totalCost; // in thousands
    protected int totalRevenue; // in thousands
    protected int lastChanged;
    protected int age;
    protected String name;

    /**
     * Default detailed information
     * 
     * @return String Name of land area
     */
    public String getDetails() {
        return "\n\n" + getName() + "\n\n";
    }

    /**
     * Default land area color
     * 
     * @return String CSS Color
     */
    public String getColor() {
        return "LIGHTGRAY";
    }

    /**
     * Default monthly money change
     * 
     * @return String Monthly money change
     */
    public String getMonthlyChange() {
        return "-$0k\n+$0k";
    }

    /**
     * Gets the land area name
     * 
     * @return String Name
     */
    public String getName() {
        return name;
    }

    /**
     * Default next month
     * 
     * @return int cost/revenue change
     */
    public int nextMonth() {
        age++;
        return 0;
    }
}
