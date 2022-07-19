package ss02_loop_in_java.practice;

import java.util.Scanner;

public class LoanInterest {
    public static void main(String[] args) {
        double money;
        int month;
        double interestRate;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter investment amount: ");
        money = scanner.nextDouble();
        System.out.println("Enter number of months: ");
        month = scanner.nextInt();
        System.out.println("Enter annual interest rate in percentage: ");
        interestRate = scanner.nextDouble();
        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }
        System.out.println("Total of interest: " + totalInterest);
    }
}
