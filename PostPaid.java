package mobile_plan_management;

class PostpaidPlan extends MobilePlan {
    private double overageCharge;

    public PostpaidPlan(String planName, double monthlyCost, int dataLimit, int callMinutes,
                        double overageCharge) {
        super(planName, monthlyCost, dataLimit, callMinutes);
        this.overageCharge = overageCharge;
    }

    @Override
    public void calculateBill(int dataUsage, int callUsage) {
        double totalCost = monthlyCost;
        boolean overData = dataUsage > dataLimit;
        boolean overCalls = callUsage > callMinutes;

        if (overData || overCalls) {
            totalCost += overageCharge;
        }

        System.out.printf("Total bill for Postpaid Plan '%s': $%.2f%n", planName, totalCost);
    }
}
