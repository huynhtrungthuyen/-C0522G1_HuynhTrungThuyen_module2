package exercise_mvc.service.impl;

import exercise_mvc.exception.DuplicateIDException;
import exercise_mvc.utils.*;
import exercise_mvc.model.Teacher;
import exercise_mvc.service.ITeacherService;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacherService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src/exercise_mvc/data/teacher.csv";

    @Override
    public void add() {
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        Teacher teacher = infoTeacher();
        teacherList.add(teacher);
        ReadWriteTeacherFileUtil.writeTeacherFile(PATH, teacherList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        System.out.println("Mời bạn nhập id cần xóa: ");
        int idRemove = Integer.parseInt(SCANNER.nextLine());
        boolean isExist = false;

        for (Teacher teacher : teacherList) {
            if (teacher.getId() == idRemove) {
                System.out.println("Giáo viên cần xóa: ");
                System.out.println(teacher);
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    teacherList.remove(teacher);
                    ReadWriteTeacherFileUtil.writeTeacherFile(PATH, teacherList);
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
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    @Override
    public void findId() {
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        System.out.println("Mời bạn nhập id cần tìm kiếm: ");
        int idFind = Integer.parseInt(SCANNER.nextLine());
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
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        System.out.println("Mời bạn nhập tên cần tìm kiếm: ");
        String nameFind = SCANNER.nextLine();
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
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
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
        ReadWriteTeacherFileUtil.writeTeacherFile(PATH, teacherList);
    }

    public static Teacher infoTeacher() {
        List<Teacher> teacherList = ReadWriteTeacherFileUtil.readTeacherFile(PATH);
        int id;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(SCANNER.nextLine());

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

        String name = MenuUtil.getName();

        String dateOfBirth = MenuUtil.getDateOfBirth();

        String gender = MenuUtil.getGender();

        System.out.print("Nhập chuyên môn: ");
        String technique = SCANNER.nextLine();

        return new Teacher(id, name, dateOfBirth, gender, technique);
    }
}
