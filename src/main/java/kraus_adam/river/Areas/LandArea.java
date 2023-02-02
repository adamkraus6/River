package kraus_adam.river.Areas;

public class LandArea {
    protected int totalCost; // in thousands
    protected int totalRevenue; // in thousands
    protected int lastChanged;
    protected int age;

    public String getName() {
        return name;
    }

    public int getCost() {
        return totalCost;
    }

    public int getRev() {
        return totalRevenue;
    }

    protected String name;

    public void nextMonth() {}
}
