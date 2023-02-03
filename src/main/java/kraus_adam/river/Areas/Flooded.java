package kraus_adam.river.Areas;

public class Flooded extends LandArea {
    public Flooded() {
        name = "Flooded";
        totalCost = 0;
        totalRevenue = 0;
    }

    @Override
    public String getColor() {
        return "LIGHTBLUE";
    }
}
