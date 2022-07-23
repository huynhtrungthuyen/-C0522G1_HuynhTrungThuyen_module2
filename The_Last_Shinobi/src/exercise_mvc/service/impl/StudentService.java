package exercise_mvc.service.impl;

import exercise_mvc.utils.DuplicateIDException;
import exercise_mvc.model.Student;
import exercise_mvc.service.IStudentService;
import exercise_mvc.utils.ReadStudentFile;
import exercise_mvc.utils.WriteStudentFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH = "src/exercise_mvc/data/student.csv";

    public void writeFile() {
        WriteStudentFile.writeStudentFile(PATH, studentList);
    }

    public void readFile() {
        List<Student> list = ReadStudentFile.readStudentFile(PATH);
        studentList.clear();
        studentList.addAll(list);
    }

    @Override
    public void add() {
        readFile();
        Student student = infoStudent();
        studentList.add(student);
        System.out.println("Thêm mới thành công!");
        writeFile();
    }

    @Override
    public void remove() {
        readFile();
        System.out.println("Mời bạn nhập id cần xóa: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Student student : studentList) {
            if (student.getId() == idRemove) {
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    studentList.remove(student);
                    System.out.println("Xóa thành công!");
                    writeFile();
                }
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public void displayAll() {
        readFile();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void findId() {
        readFile();
        System.out.println("Mời bạn nhập id cần tìm kiếm: ");
        int idFind = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Student student : studentList) {
            if (student.getId() == idFind) {
                System.out.println(student);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public void findName() {
        readFile();
        System.out.println("Mời bạn nhập tên cần tìm kiếm: ");
        String nameFind = scanner.nextLine();
        boolean isExist = false;

        for (Student student : studentList) {
            if (student.getName().toLowerCase().contains(nameFind.toLowerCase())) {
                System.out.println(student);
                isExist = true;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public void sortByName() {
        readFile();
        boolean isSwap = true;
        for (int i = 0; i < studentList.size() && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < studentList.size() - 1 - i; j++) {

                if (studentList.get(j).getName().compareTo(studentList.get(j + 1).getName()) > 0) {
                    Collections.swap(studentList, j, j + 1);
                    isSwap = true;
                } else if (studentList.get(j).getName().compareTo(studentList.get(j + 1).getName()) == 0) {
                    if (studentList.get(j).getId() > studentList.get(j + 1).getId()) {
                        Collections.swap(studentList, j, j + 1);
                    }
                }
            }
        }

        System.out.println("Danh sách học sinh sau khi sắp xếp: ");
        for (Student student : studentList) {
            System.out.println(student);
        }
        writeFile();
    }

    public static Student infoStudent() {
        int id;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(scanner.nextLine());

                for (Student student : studentList) {
                    if (student.getId() == id) {
                        throw new DuplicateIDException("Trùng id, vui lòng nhập lại!");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập name: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String dateOfBirth = scanner.nextLine();

        System.out.print("Nhập giới tính: ");
        String gender = scanner.nextLine();

        System.out.print("Nhập tên lớp: ");
        String className = scanner.nextLine();

        double point;
        while (true) {
            try {
                System.out.print("Nhập điểm: ");
                point = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

        return new Student(id, name, dateOfBirth, gender, className, point);
    }
}
