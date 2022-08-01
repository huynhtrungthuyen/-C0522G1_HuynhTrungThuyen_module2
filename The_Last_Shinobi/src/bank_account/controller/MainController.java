package bank_account.controller;

import java.util.Scanner;

public class MainController {
    public static void menuController() {
        PaymentAccountController paymentAccountController = new PaymentAccountController();
        SavingAccountController savingAccountController = new SavingAccountController();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG.\n" +
                    "1. Quản lí tài khoản tiết kiệm.\n" +
                    "2. Quản lí tài khoản thanh toán.\n" +
                    "3. Thoát chương trình.");

            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    savingAccountController.menuSaving();
                    break;
                case 2:
                    paymentAccountController.menuPayment();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
