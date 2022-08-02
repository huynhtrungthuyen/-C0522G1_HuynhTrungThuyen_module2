package team_bank.controller;

import team_bank.service.IPaymentBankAccountService;
import team_bank.service.impl.PaymentBankAccountService;

import java.util.Scanner;

public class PaymentAccountController {
    public void menuPayment() {
        Scanner scanner = new Scanner(System.in);
        IPaymentBankAccountService iPaymentBankAccountService = new PaymentBankAccountService();
        do {
            System.out.println("Quản lí tài khoản thanh toán: \n" +
                    "1. Thêm mới tài khoản. \n" +
                    "2. Xóa tài khoản. \n" +
                    "3. Xem danh sách tài khoản. \n" +
                    "4. Tìm kiếm tài khoản. \n" +
                    "5. Quay về menu chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    iPaymentBankAccountService.add();
                    break;
                case 2:
                    iPaymentBankAccountService.remove();
                    break;
                case 3:
                    iPaymentBankAccountService.display();
                    break;
                case 4:
                    iPaymentBankAccountService.find();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
