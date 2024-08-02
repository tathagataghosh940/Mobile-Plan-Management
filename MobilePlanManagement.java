package mobile_plan_management;

import java.util.ArrayList;
import java.util.Scanner;

public class MobilePlanManagement {
    private ArrayList<MobilePlan> mobilePlans;

    public MobilePlanManagement() {
        mobilePlans = new ArrayList<>();
    }

    // Method to add a new mobile plan
    public void addMobilePlan(MobilePlan plan) {
        mobilePlans.add(plan);
        System.out.println("Mobile plan added successfully.");
    }

    // Method to remove a mobile plan by name
    public void removeMobilePlan(String planName) {
        MobilePlan planToRemove = null;
        for (MobilePlan plan : mobilePlans) {
            if (plan.planName.equalsIgnoreCase(planName)) {
                planToRemove = plan;
                break;
            }
        }

        if (planToRemove != null) {
            mobilePlans.remove(planToRemove);
            System.out.println("Mobile plan removed successfully.");
        } else {
            System.out.println("Mobile plan not found.");
        }
    }

    // Method to view all mobile plans
    public void viewMobilePlans() {
        if (mobilePlans.isEmpty()) {
            System.out.println("No mobile plans available.");
        } else {
            System.out.println("List of Mobile Plans:");
            for (MobilePlan plan : mobilePlans) {
                System.out.println(plan);
            }
        }
    }

    // Main method for user interaction
    public static void main(String[] args) {
        MobilePlanManagement planManagement = new MobilePlanManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMobile Plan Management System");
            System.out.println("1. Add Mobile Plan");
            System.out.println("2. Remove Mobile Plan");
            System.out.println("3. View Mobile Plans");
            System.out.println("4. Calculate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Select plan type (1: Prepaid, 2: Postpaid): ");
                    int planType = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter plan name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter monthly cost: ");
                    double cost = scanner.nextDouble();
                    System.out.print("Enter data limit (GB): ");
                    int dataLimit = scanner.nextInt();
                    System.out.print("Enter call minutes: ");
                    int callMinutes = scanner.nextInt();

                    if (planType == 1) {
                        System.out.print("Enter data rate per GB (over limit): ");
                        double dataRate = scanner.nextDouble();
                        System.out.print("Enter call rate per minute (over limit): ");
                        double callRate = scanner.nextDouble();
                        MobilePlan prepaidPlan = new PrepaidPlan(name, cost, dataLimit, callMinutes, dataRate, callRate);
                        planManagement.addMobilePlan(prepaidPlan);
                    } else if (planType == 2) {
                        System.out.print("Enter overage charge: ");
                        double overageCharge = scanner.nextDouble();
                        MobilePlan postpaidPlan = new PostpaidPlan(name, cost, dataLimit, callMinutes, overageCharge);
                        planManagement.addMobilePlan(postpaidPlan);
                    } else {
                        System.out.println("Invalid plan type selected.");
                    }
                    break;

                case 2:
                    System.out.print("Enter the name of the mobile plan to remove: ");
                    String planName = scanner.nextLine();
                    planManagement.removeMobilePlan(planName);
                    break;

                case 3:
                    planManagement.viewMobilePlans();
                    break;

                case 4:
                    System.out.print("Enter the name of the mobile plan to calculate bill: ");
                    String planToCalculate = scanner.nextLine();

                    MobilePlan selectedPlan = null;
                    for (MobilePlan plan : planManagement.mobilePlans) {
                        if (plan.planName.equalsIgnoreCase(planToCalculate)) {
                            selectedPlan = plan;
                            break;
                        }
                    }

                    if (selectedPlan != null) {
                        System.out.print("Enter data usage (GB): ");
                        int dataUsage = scanner.nextInt();
                        System.out.print("Enter call usage (minutes): ");
                        int callUsage = scanner.nextInt();
                        selectedPlan.calculateBill(dataUsage, callUsage);
                    } else {
                        System.out.println("Mobile plan not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}