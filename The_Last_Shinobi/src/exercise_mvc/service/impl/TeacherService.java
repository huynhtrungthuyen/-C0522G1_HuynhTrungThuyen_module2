package exercise_mvc.service.impl;

import exercise_mvc.utils.*;
import exercise_mvc.model.Teacher;
import exercise_mvc.service.ITeacherService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static List<Teacher> teacherList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String PATH = "src/exercise_mvc/data/teacher.csv";

    public void writeFile() {
        WriteTeacherFile.writeTeacherFile(PATH, teacherList);
    }

    public void readFile() {
        List<Teacher> list = ReadTeacherFile.readTeacherFile(PATH);
        teacherList.clear();
        teacherList.addAll(list);
    }

    @Override
    public void add() {
        readFile();
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        System.out.println("Thêm mới thành công!");
        writeFile();
    }

    @Override
    public void remove() {
        readFile();
        System.out.println("Mời bạn nhập id cần xóa: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idRemove) {
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    teacherList.remove(teacher);
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
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void findId() {
        readFile();
        System.out.println("Mời bạn nhập id cần tìm kiếm: ");
        int idFind = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idFind) {
                System.out.println(teacher);
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

        for (Teacher teacher : teacherList) {
            if (teacher.getName().toLowerCase().contains(nameFind.toLowerCase())) {
                System.out.println(teacher);
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
        for (int i = 0; i < teacherList.size() && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < teacherList.size() - 1 - i; j++) {

                if (teacherList.get(j).getName().compareTo(teacherList.get(j + 1).getName()) > 0) {
                    Collections.swap(teacherList, j, j + 1);
                    isSwap = true;
                } else if (teacherList.get(j).getName().compareTo(teacherList.get(j + 1).getName()) == 0) {
                    if (teacherList.get(j).getId() > teacherList.get(j + 1).getId()) {
                        Collections.swap(teacherList, j, j + 1);
                    }
                }
            }
        }

        System.out.println("Danh sách học sinh sau khi sắp xếp: ");
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
        writeFile();
    }

    public static Teacher infoTeacher() {
        int id;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(scanner.nextLine());

                for (Teacher teacher : teacherList) {
                    if (teacher.getId() == id) {
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

        System.out.print("Nhập chuyên môn: ");
        String technique = scanner.nextLine();

        return new Teacher(id, name, dateOfBirth, gender, technique);
    }
}
