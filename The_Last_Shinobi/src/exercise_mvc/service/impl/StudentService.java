package exercise_mvc.service.impl;

import exercise_mvc.exception.DuplicateIDException;
import exercise_mvc.model.Student;
import exercise_mvc.service.IStudentService;
import exercise_mvc.utils.ReadWriteStudentFile;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src/exercise_mvc/data/student.csv";

    @Override
    public void add() {
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        Student student = infoStudent();
        studentList.add(student);
        ReadWriteStudentFile.writeStudentFile(PATH, studentList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        System.out.println("Mời bạn nhập id cần xóa: ");
        int idRemove = Integer.parseInt(SCANNER.nextLine());
        boolean isExist = false;

        for (Student student : studentList) {
            if (student.getId() == idRemove) {
                System.out.println("Học sinh cần xóa: ");
                System.out.println(student);
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    studentList.remove(student);
                    ReadWriteStudentFile.writeStudentFile(PATH, studentList);
                    System.out.println("Xóa thành công!");
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
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void findId() {
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        System.out.println("Mời bạn nhập id cần tìm kiếm: ");
        int idFind = Integer.parseInt(SCANNER.nextLine());
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
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        System.out.println("Mời bạn nhập tên cần tìm kiếm: ");
        String nameFind = SCANNER.nextLine();
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
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
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
        ReadWriteStudentFile.writeStudentFile(PATH, studentList);
    }

    public static Student infoStudent() {
        List<Student> studentList = ReadWriteStudentFile.readStudentFile(PATH);
        int id;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(SCANNER.nextLine());

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
        String name = SCANNER.nextLine();

        System.out.print("Nhập ngày sinh: ");
        String dateOfBirth = SCANNER.nextLine();

        String gender = getGender();

        System.out.print("Nhập tên lớp: ");
        String className = SCANNER.nextLine();

        double point;
        while (true) {
            try {
                System.out.print("Nhập điểm: ");
                point = Double.parseDouble(SCANNER.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

        return new Student(id, name, dateOfBirth, gender, className, point);
    }

    public static String getGender() {
        System.out.println("Nhập giới tính:\n" +
                "1. Nam.\n" +
                "2. Nữ.\n" +
                "3. Giới tính thứ 3.");
        int choose = 0;
        do {
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    return "nam";
                case 2:
                    return "nữ";
                case 3:
                    return "giới tính thứ 3";
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng chọn lại!");
            }
        } while (true);
    }
}
