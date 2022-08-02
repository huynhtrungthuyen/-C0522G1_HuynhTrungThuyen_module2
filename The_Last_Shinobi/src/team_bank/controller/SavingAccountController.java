package team_bank.controller;

import team_bank.service.ISavingBankAccountService;
import team_bank.service.impl.SavingBankAccountService;

import java.util.Scanner;

public class SavingAccountController {
    public void menuSaving() {
        Scanner scanner = new Scanner(System.in);
        ISavingBankAccountService iSavingBankAccountService = new SavingBankAccountService();
        do {
            System.out.println("Quản lí tài khoản tiết kiệm: \n" +
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
                    iSavingBankAccountService.add();
                    break;
                case 2:
                    iSavingBankAccountService.remove();
                    break;
                case 3:
                    iSavingBankAccountService.display();
                    break;
                case 4:
                    iSavingBankAccountService.find();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
