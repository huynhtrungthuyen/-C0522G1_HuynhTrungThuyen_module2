package exercise_mvc.controller;

import exercise_mvc.service.ITeacherService;
import exercise_mvc.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    public void menuTeacher() {
        Scanner scanner = new Scanner(System.in);
        ITeacherService iTeacherService = new TeacherService();
        do {
            System.out.println("Quản lí giáo viên: \n" +
                    "1. Thêm mới giáo viên. \n" +
                    "2. Xóa giáo viên. \n" +
                    "3. Xem danh sách giáo viên. \n" +
                    "4. Tìm kiếm giáo viên theo id. \n" +
                    "5. Tìm kiếm giáo viên theo tên. \n" +
                    "6. Sắp xếp giáo viên theo tên. \n" +
                    "7. Quay về menu chính.");
            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    iTeacherService.add();
                    break;
                case 2:
                    iTeacherService.remove();
                    break;
                case 3:
                    iTeacherService.displayAll();
                    break;
                case 4:
                    iTeacherService.findId();
                    break;
                case 5:
                    iTeacherService.findName();
                    break;
                case 6:
                    iTeacherService.sortByName();
                    break;
                case 7:
                    return;
            }
        } while (true);
    }
}
