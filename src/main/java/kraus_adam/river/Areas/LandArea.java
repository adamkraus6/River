package kraus_adam.river.Areas;

public class LandArea {
    protected int totalCost; // in thousands
    protected int totalRevenue; // in thousands
    protected int lastChanged;
    protected int age;
    protected String name;

    public String getDetails() {
        return "\n\n" + getName() + "\n\n";
    }

    public String getColor() {
        return "LIGHTGRAY";
    }

    public String getMonthlyChange() {
        return "-$0k\n+$0k";
    }

    public String getName() {
        return name;
    }

    public int nextMonth() {
        age++;
        return 0;
    }
}
