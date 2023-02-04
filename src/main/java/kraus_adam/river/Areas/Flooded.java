package kraus_adam.river.Areas;

public class Flooded extends LandArea {
    /**
     * Flooded land area constructor
     */
    public Flooded() {
        name = "Flooded";
        totalCost = 0;
        totalRevenue = 0;
    }

    
    /** 
     * Gets the color chosen for the Flooded land area
     * @return String
     */
    @Override
    public String getColor() {
        return "LIGHTBLUE";
    }
}
