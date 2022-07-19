package exercise_mvc.service.impl;

import exercise_mvc.model.Student;
import exercise_mvc.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        Student student = infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập id cần xóa: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Student student : studentList) {
            if(student.getId() == idRemove) {
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    studentList.remove(student);
                    System.out.println("Xóa thành công!");
                }
                isExist = true;
                break;
            }
        }

        if(!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public void displayAll() {
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void find() {
        int choose;
        boolean isExist = false;

        do {
            System.out.println("Tìm kiểm theo: \n" +
                    "1. Id.\n" +
                    "2. Tên.");
            choose = Integer.parseInt(scanner.nextLine());

            if (choose != 1 && choose != 2) {
                System.out.println("Nhập lại!");
            }
        } while (choose != 1 && choose != 2);

        if (choose == 1) {
            System.out.println("Mời bạn nhập id cần tìm kiếm: ");
            int idFind = Integer.parseInt(scanner.nextLine());

            for (Student student : studentList) {
                if (student.getId() == idFind) {
                    System.out.println(student);
                    isExist = true;
                    break;
                }
            }
        }
        else {
            System.out.println("Mời bạn nhập tên cần tìm kiếm: ");
            String nameFind = scanner.nextLine();

            for (Student student : studentList) {
                if (student.getName().contains(nameFind)) {
                    System.out.println(student);
                    isExist = true;
                }
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    public static Student infoStudent() {
        System.out.print("Nhập id: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Nhập giới tính:\n" +
                "1. Nam.\n" +
                "2. Nữ.\n" +
                "Khác. LGBT.");
        int gender = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();

        System.out.print("Nhập điểm: ");
        double point = Double.parseDouble(scanner.nextLine());

        return new Student(id, name, dateOfBirth, gender, className, point);
    }
}
