package final_module_2.controller;

import exercise_mvc.controller.StudentController;
import exercise_mvc.controller.TeacherController;

import java.util.Scanner;

public class MainController {
    public static void menuController() {
        AController aController = new AController();
        BController bController = new BController();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("\nỨNG DỤNG QUẢN LÍ.\n" +
                    "1. Quản lí A.\n" +
                    "2. Quản lí B.\n" +
                    "3. Thoát chương trình.");

            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                e.getStackTrace();
            }
            switch (choose) {
                case 1:
                    aController.menuA();
                    break;
                case 2:
                    bController.menuB();
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không có, vui lòng chọn lại!");
            }
        } while (true);
    }
}
