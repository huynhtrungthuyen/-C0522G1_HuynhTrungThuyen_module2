package case_study.controller;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuCustomerManagement() {
        do {
            System.out.println("CUSTOMER MANAGEMENT MENU: \n" +
                    "1. Display list customers.\n" +
                    "2. Add new customer.\n" +
                    "3. Edit customer.\n" +
                    "4. Return main menu.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
//                    truck.add();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    return;
            }
        } while (true);
    }
}
