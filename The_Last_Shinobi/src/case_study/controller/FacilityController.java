package case_study.controller;

import java.util.Scanner;

public class FacilityController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuFacilityManagement() {
        do {
            System.out.println("FACILITY MANAGEMENT MENU: \n" +
                    "1. Display list facility.\n" +
                    "2. Add new facility.\n" +
                    "3. Display list facility maintenance.\n" +
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
