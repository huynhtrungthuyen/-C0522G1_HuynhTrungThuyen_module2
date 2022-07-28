package case_study.service.impl;

import case_study.model.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.MenuUtil;
import case_study.utils.ReadWriteEmployeeFileUtil;
import case_study.utils.RegexExceptionUtil;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final String PATH_EMPLOYEE = "src/case_study/data/employee.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        List<Employee> employeeList = ReadWriteEmployeeFileUtil.readEmployeeFile(PATH_EMPLOYEE);
        System.out.print("Nhập mã số nhân viên: ");
        boolean isExistId;
        String id;
        do {
            isExistId = false;
            id = SCANNER.nextLine();
            for (Employee employee : employeeList) {
                if (id.equals(employee.getId())) {
                    System.out.println("Mã nhân viên đã tồn tại, vui lòng nhập lại!");
                    isExistId = true;
                    break;
                }
            }
        } while (isExistId);

        System.out.print("Nhập tên nhân viên: ");
        String name = SCANNER.nextLine();

        String dateOfBirth = RegexExceptionUtil.getDateOfBirth();

        String gender = MenuUtil.getGender();

        System.out.print("Nhập số CMND nhân viên: ");
        String idCard = SCANNER.nextLine();

        System.out.print("Nhập số điện thoại nhân viên: ");
        String phone = SCANNER.nextLine();

        System.out.print("Nhập email nhân viên: ");
        String email = SCANNER.nextLine();

        String level = MenuUtil.getLevel();

        String position = MenuUtil.getPosition();

        System.out.print("Nhập lương nhân viên (VNĐ/tháng): ");
        int salary;
        do {
            try {
                salary = Integer.parseInt(SCANNER.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        } while (true);

        employeeList.add(new Employee(id, name, dateOfBirth, gender, idCard, phone, email, level, position, salary));
        ReadWriteEmployeeFileUtil.writeEmployeeFile(PATH_EMPLOYEE, employeeList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        List<Employee> employeeList = ReadWriteEmployeeFileUtil.readEmployeeFile(PATH_EMPLOYEE);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        List<Employee> employeeList = ReadWriteEmployeeFileUtil.readEmployeeFile(PATH_EMPLOYEE);
        System.out.print("Nhập mã số nhân viên cần chỉnh sửa: ");
        String idEdit = SCANNER.nextLine();
        boolean isExist = false;

        for (int i = 0; i < employeeList.size(); i++) {
            if (idEdit.equals((employeeList.get(i).getId()))) {
                System.out.println("Nhân viên muốn chỉnh sửa: ");
                System.out.println(employeeList.get(i));
                System.out.println("Bạn có chắc muốn chỉnh sửa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    System.out.print("Nhập tên nhân viên: ");
                    String name = SCANNER.nextLine();

                    System.out.print("Nhập ngày sinh nhân viên: ");
                    String dateOfBirth = SCANNER.nextLine();

                    String gender = MenuUtil.getGender();

                    System.out.print("Nhập số CMND nhân viên: ");
                    String idCard = SCANNER.nextLine();

                    System.out.print("Nhập số điện thoại nhân viên: ");
                    String phone = SCANNER.nextLine();

                    System.out.print("Nhập email nhân viên: ");
                    String email = SCANNER.nextLine();

                    String level = MenuUtil.getLevel();

                    String position = MenuUtil.getPosition();

                    System.out.print("Nhập lương nhân viên (VNĐ/tháng): ");
                    int salary;
                    do {
                        try {
                            salary = Integer.parseInt(SCANNER.nextLine());
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("Vui lòng nhập số!");
                        }
                    } while (true);

                    employeeList.set(i, new Employee(idEdit, name, dateOfBirth, gender, idCard, phone, email, level, position, salary));
                    ReadWriteEmployeeFileUtil.writeEmployeeFile(PATH_EMPLOYEE, employeeList);
                    System.out.println("Chỉnh sửa thành công!");
                }

                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }
}
