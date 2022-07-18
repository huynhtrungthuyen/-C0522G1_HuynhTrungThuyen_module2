package case_study.controller;

import java.util.Scanner;

public class PromotionController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuPromotionManagement() {
        do {
            System.out.println("PROMOTION MANAGEMENT MENU: \n" +
                    "1. Display list customers use service.\n" +
                    "2. Display list customers get voucher.\n" +
                    "3. Return main menu.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
//                    truck.add();
                    break;
                case 2:
                    break;
                case 3:
                    return;
            }
        } while (true);
    }
}
