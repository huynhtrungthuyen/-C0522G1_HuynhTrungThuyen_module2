package case_study.controller;

import java.util.Scanner;

public class PromotionController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuPromotionManagement() {
        do {
            System.out.println("QUẢN LÝ KHUYẾN MÃI\n" +
                    "1. Hiển thị danh sách khách hàng sử dụng dịch vụ.\n" +
                    "2. Hiển thị danh sách khách hàng nhận được voucher.\n" +
                    "3. Trở về MENU chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }

            switch (choose) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
