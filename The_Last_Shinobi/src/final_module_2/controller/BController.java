package final_module_2.controller;

import final_module_2.service.IBService;
import final_module_2.service.impl.BService;

import java.util.Scanner;

public class BController {
    public void menuB() {
        Scanner scanner = new Scanner(System.in);
        IBService ibService = new BService();
        do {
            System.out.println("\nQuản lí B: \n" +
                    "1. Thêm mới B. \n" +
                    "2. Xóa B. \n" +
                    "3. Hiển thị B. \n" +
                    "4. Tìm kiếm B. \n" +
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
                    ibService.add();
                    break;
                case 2:
                    ibService.remove();
                    break;
                case 3:
                    ibService.display();
                    break;
                case 4:
                    ibService.find();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
