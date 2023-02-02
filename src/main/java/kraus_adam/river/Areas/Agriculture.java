package kraus_adam.river.Areas;

public class Agriculture extends LandArea {
    public Agriculture() {
        name = "Agriculture";
        totalCost = 300;
        totalRevenue = 0;
    }

    public void nextMonth() {
        totalRevenue += 65;
    }
}
