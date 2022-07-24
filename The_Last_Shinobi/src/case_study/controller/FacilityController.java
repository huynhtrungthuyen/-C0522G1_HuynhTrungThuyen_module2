package case_study.controller;

import java.util.Scanner;

public class FacilityController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuFacilityManagement() {
        do {
            System.out.println("QUẢN LÝ CƠ SỞ:\n" +
                    "1. Hiển thị cơ sở.\n" +
                    "2. Thêm mới cơ sở.\n" +
                    "3. Hiển thị danh sách bảo trì cơ sở.\n" +
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
