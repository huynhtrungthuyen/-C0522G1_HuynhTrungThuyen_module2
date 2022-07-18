package case_study.controller;

import java.util.Scanner;

public class EmployeeController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuEmployeeManagement() {
        do {
            System.out.println("EMPLOYEE MANAGEMENT MENU: \n" +
                    "1. Display list employees.\n" +
                    "2. Add new employee.\n" +
                    "3. Edit employee.\n" +
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
