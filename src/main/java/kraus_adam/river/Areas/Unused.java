package kraus_adam.river.Areas;

public class Unused extends LandArea {
    /**
     * Unused land area constructor
     * @param created Time of creation
     */
    public Unused(int created) {
        name = "Unused";
        totalCost = 0;
        totalRevenue = 0;
        age = 0;
        lastChanged = created;
    }

    
    /** 
     * Gets the detailed land area information
     * @return String Detailed information
     */
    @Override
    public String getDetails() {
        int changedYear = lastChanged / 12;
        int changedMonth = (lastChanged % 12) + 1;
        int ageYear = age / 12;
        int ageMonth = (age % 12) + 1;
        String details = name + "\nLast changed: " + changedYear + "-" + changedMonth +
                "\nAge: " + ageYear + "-" + ageMonth +
                "\nTotal Cost: $0k\nTotal Revenue: $0k";
        return details;
    }
}
