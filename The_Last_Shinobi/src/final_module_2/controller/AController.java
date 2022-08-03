package final_module_2.controller;

import final_module_2.service.IAService;
import final_module_2.service.impl.AService;

import java.util.Scanner;

public class AController {
    public void menuA() {
        Scanner scanner = new Scanner(System.in);
        IAService iaService = new AService();
        do {
            System.out.println("\nQuản lí A: \n" +
                    "1. Thêm mới A. \n" +
                    "2. Xóa A. \n" +
                    "3. Hiển thị A. \n" +
                    "4. Tìm kiếm A. \n" +
                    "5. Quay về menu chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }
            switch (choose) {
                case 1:
                    iaService.add();
                    break;
                case 2:
                    iaService.remove();
                    break;
                case 3:
                    iaService.display();
                    break;
                case 4:
                    iaService.find();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
