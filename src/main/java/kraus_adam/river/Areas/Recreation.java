package kraus_adam.river.Areas;

public class Recreation extends LandArea {
    /**
     * Recreation land area constructor
     * 
     * @param created Time of creation
     */
    public Recreation(int created) {
        name = "Recreation";
        totalCost = 10;
        totalRevenue = 0;
        age = 0;
        lastChanged = created;
    }

    /**
     * Calculates the change in cost/revenue for a new month
     * 
     * @return int cost/revenue change
     */
    @Override
    public int nextMonth() {
        age++;
        int month = (age + lastChanged) % 12;
        int change = 0;
        if (month == 11) {
            change = 5;
            totalRevenue += change;
        }
        return change;
    }

    /**
     * Gets the monthly money change for cost/revenue
     * 
     * @return String Monthly money change
     */
    @Override
    public String getMonthlyChange() {
        int time = age + lastChanged;
        int month = time % 12;
        int minus = 0;
        int plus = 0;
        if (age == 0) // first month creation
            minus = 10;
        else if (month == 11)
            plus = 5;
        return "-$" + minus + "k\n+$" + plus + "k";
    }

    /**
     * Gets the detailed land area information
     * 
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
                "\nTotal Cost: $" + totalCost + "k\nTotal Revenue: $" + totalRevenue + "k";
        return details;
    }

    /**
     * Gets the color chosen for the Recreation land area
     * 
     * @return String
     */
    @Override
    public String getColor() {
        return "LIGHTCORAL";
    }
}
