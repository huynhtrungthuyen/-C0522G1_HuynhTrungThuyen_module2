package case_study.controller;

import java.util.Scanner;

public class CustomerController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuCustomerManagement() {
        do {
            System.out.println("QUẢN LÝ KHÁCH HÀNG:\n" +
                    "1. Hiển thị danh sách khách hàng.\n" +
                    "2. Thêm mới khách hàng.\n" +
                    "3. Chỉnh sửa khách hàng.\n" +
                    "4. Trở về MENU chính.");
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
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
