package case_study.controller;

import java.util.Scanner;

public class BookingController {
    private final Scanner scanner = new Scanner(System.in);

    public void menuBookingManagement() {
        do {
            System.out.println("QUẢN LÝ ĐẶT CHỖ:\n" +
                    "1. Thêm mới đặt chỗ.\n" +
                    "2. Hiển thị danh sách đặt chỗ.\n" +
                    "3. Tạo hợp đồng mới.\n" +
                    "4. Hiển thị danh sách hợp đồng.\n" +
                    "5. Chỉnh sửa hợp đồng.\n" +
                    "6. Trở về MENU chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e) {
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
                    break;
                case 5:
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
