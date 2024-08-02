package mobile_plan_management;

class PrepaidPlan extends MobilePlan {
    private double dataRatePerGB;
    private double callRatePerMin;

    public PrepaidPlan(String planName, double monthlyCost, int dataLimit, int callMinutes,
                       double dataRatePerGB, double callRatePerMin) {
        super(planName, monthlyCost, dataLimit, callMinutes);
        this.dataRatePerGB = dataRatePerGB;
        this.callRatePerMin = callRatePerMin;
    }

    @Override
    public void calculateBill(int dataUsage, int callUsage) {
        double totalCost = monthlyCost;
        int extraData = Math.max(dataUsage - dataLimit, 0);
        int extraMinutes = Math.max(callUsage - callMinutes, 0);

        totalCost += extraData * dataRatePerGB;
        totalCost += extraMinutes * callRatePerMin;

        System.out.printf("Total bill for Prepaid Plan '%s': $%.2f%n", planName, totalCost);
    }
}