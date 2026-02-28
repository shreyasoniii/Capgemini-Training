package IntresertCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nSelect the option:");
            System.out.println("1. Interest Calculator – SB");
            System.out.println("2. Interest Calculator – FD");
            System.out.println("3. Interest Calculator – RD");
            System.out.println("4. Exit");

            choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter the average Amount of your Account");
                        double sbAmount = sc.nextDouble();
                        System.out.println("Enter account type(Normal/NRI):");
                        String accType = sc.next();
                        if (sbAmount < 0)
                            throw new NegativeValueException("Amount cannot be negative");

                        Account sb = new SBAccount(sbAmount, accType);
                        System.out.println("Interest gained: Rs. " + sb.calculateInterest());
                        break;

                    case 2: // FD
                        System.out.println("Enter the FD amount:");
                        double fdAmount = sc.nextDouble();

                        System.out.println("Enter the number of days:");
                        int days = sc.nextInt();

                        System.out.println("Enter your age:");
                        int age = sc.nextInt();

                        if (fdAmount < 0 || days < 0 || age < 0)
                            throw new NegativeValueException("Negative values are not allowed");

                        Account fd = new FDAccount(fdAmount, days, age);
                        System.out.println("Interest gained: Rs. " + fd.calculateInterest());
                        break;

                    case 3: // RD
                        System.out.println("Enter the monthly amount:");
                        double monthlyAmount = sc.nextDouble();

                        System.out.println("Enter the number of months:");
                        int months = sc.nextInt();

                        System.out.println("Enter your age:");
                        int rdAge = sc.nextInt();

                        if (monthlyAmount < 0 || months < 0 || rdAge < 0)
                            throw new NegativeValueException("Negative values are not allowed");

                        Account rd = new RDAccount(monthlyAmount, months, rdAge);
                        System.out.println("Interest gained: Rs. " + rd.calculateInterest());
                        break;

                    case 4:
                        System.out.println("Thank you!");
                        break;

                    default:
                        System.out.println("Invalid option. Try again.");
                }

            } catch (NegativeValueException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter correct values.");
                sc.nextLine(); // clear buffer
            }

        } while (choice != 4);

        sc.close();
    }
}