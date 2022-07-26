package exercise_mvc.service.impl;

import exercise_mvc.exception.DuplicateIDException;
import exercise_mvc.model.Student;
import exercise_mvc.service.IStudentService;
import exercise_mvc.utils.MenuUtil;
import exercise_mvc.utils.ReadWriteStudentFileUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src/exercise_mvc/data/student.csv";

    @Override
    public void add() {
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
        Student student = infoStudent();
        studentList.add(student);
        ReadWriteStudentFileUtil.writeStudentFile(PATH, studentList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
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
                    ReadWriteStudentFileUtil.writeStudentFile(PATH, studentList);
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
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Override
    public void findId() {
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
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
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
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
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
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
        ReadWriteStudentFileUtil.writeStudentFile(PATH, studentList);
    }

    public static Student infoStudent() {
        List<Student> studentList = ReadWriteStudentFileUtil.readStudentFile(PATH);
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

        String name = MenuUtil.getName();

        String dateOfBirth = MenuUtil.getDateOfBirth();

        String gender = MenuUtil.getGender();

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
}
