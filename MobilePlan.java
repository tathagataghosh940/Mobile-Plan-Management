package mobile_plan_management;

abstract class MobilePlan {
    protected String planName;
    protected double monthlyCost;
    protected int dataLimit;
    protected int callMinutes;

    public MobilePlan(String planName, double monthlyCost, int dataLimit, int callMinutes) {
        this.planName = planName;
        this.monthlyCost = monthlyCost;
        this.dataLimit = dataLimit;
        this.callMinutes = callMinutes;
    }

    public abstract void calculateBill(int dataUsage, int callUsage);

    @Override
    public String toString() {
        return "Plan Name: " + planName + ", Monthly Cost: $" + monthlyCost +
                ", Data Limit: " + dataLimit + "GB, Call Minutes: " + callMinutes + " mins";
    }
}