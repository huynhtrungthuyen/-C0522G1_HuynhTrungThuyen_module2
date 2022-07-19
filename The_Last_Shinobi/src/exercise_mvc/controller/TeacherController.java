package exercise_mvc.controller;

import exercise_mvc.service.ITeacherService;
import exercise_mvc.service.impl.TeacherService;

import java.util.Scanner;

public class TeacherController {
    private Scanner scanner = new Scanner(System.in);
    private ITeacherService iTeacherService = new TeacherService();

    public void menuTeacher() {
        do {
            System.out.println("Quản lí giáo viên: \n" +
                    "1. Thêm mới giáo viên. \n" +
                    "2. Xóa giáo viên. \n" +
                    "3. Xem danh sách giáo viên. \n" +
                    "4. Tìm kiếm giáo viên. \n" +
                    "5. Quay về menu chính.");
            int choose = Integer.parseInt(scanner.nextLine());
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
                    iTeacherService.find();
                    break;
                case 5:
                    return;
            }
        } while (true);
    }
}
