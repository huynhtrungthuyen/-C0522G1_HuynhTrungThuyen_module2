package case_study.service.impl;

import case_study.Model.Employee;
import case_study.service.IEmployeeService;
import case_study.utils.ReadWriteEmployeeFile;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private static final String PATH_EMPLOYEE = "src/case_study/data/employee.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    public String getGender() {
        System.out.println("Nhập giới tính nhân viên:\n" +
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

    public String getLevel() {
        System.out.println("Nhập trình độ nhân viên:\n" +
                "1. Trung cấp.\n" +
                "2. Cao đẳng.\n" +
                "3. Đại Học.\n" +
                "4. Sau đại học.");
        int choose = 0;
        do {
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    return "trung cấp";
                case 2:
                    return "cao đẳng";
                case 3:
                    return "đại học";
                case 4:
                    return "sau đại học";
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng chọn lại!");
            }
        } while (true);
    }

    public String getPosition() {
        System.out.println("Nhập vị trí nhân viên:\n" +
                "1. Lễ Tân.\n" +
                "2. Phục vụ.\n" +
                "3. Chuyên viên.\n" +
                "4. Giám sát.\n" +
                "5. Quản lý.\n" +
                "6. Giám đốc.");
        int choose = 0;
        do {
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    return "lễ tân";
                case 2:
                    return "phục vụ";
                case 3:
                    return "chuyên viên";
                case 4:
                    return "giám sát";
                case 5:
                    return "quản lý";
                case 6:
                    return "giám đốc";
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng chọn lại!");
            }
        } while (true);
    }

    @Override
    public void add() {
        List<Employee> employeeList = ReadWriteEmployeeFile.readEmployeeFile(PATH_EMPLOYEE);
        System.out.print("Nhập mã số nhân viên: ");
        boolean isExistId;
        String id;
        do {
            isExistId = false;
            id = SCANNER.nextLine();
            for (Employee employee : employeeList) {
                if (id.equals(employee.getId())) {
                    isExistId = true;
                    break;
                }
            }
        } while (isExistId);

        System.out.print("Nhập tên nhân viên: ");
        String name = SCANNER.nextLine();

        System.out.print("Nhập ngày sinh nhân viên: ");
        String dateOfBirth = SCANNER.nextLine();

        String gender = getGender();

        System.out.print("Nhập số CMND nhân viên: ");
        String idCard = SCANNER.nextLine();

        System.out.print("Nhập số điện thoại nhân viên: ");
        String phone = SCANNER.nextLine();

        System.out.print("Nhập email nhân viên: ");
        String email = SCANNER.nextLine();

        String level = getLevel();

        String position = getPosition();

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
        ReadWriteEmployeeFile.writeEmployeeFile(PATH_EMPLOYEE, employeeList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        List<Employee> employeeList = ReadWriteEmployeeFile.readEmployeeFile(PATH_EMPLOYEE);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Override
    public void edit() {
        List<Employee> employeeList = ReadWriteEmployeeFile.readEmployeeFile(PATH_EMPLOYEE);
        System.out.print("Nhập mã số nhân viên cần chỉnh sửa: ");
        String idEdit = SCANNER.nextLine();
        boolean isExist = false;

        for (int i = 0; i < employeeList.size(); i++) {
            if (idEdit.equals((employeeList.get(i).getId()))) {
                System.out.println("Bạn có chắc muốn chỉnh sửa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    System.out.print("Nhập tên nhân viên: ");
                    String name = SCANNER.nextLine();

                    System.out.print("Nhập ngày sinh nhân viên: ");
                    String dateOfBirth = SCANNER.nextLine();

                    String gender = getGender();

                    System.out.print("Nhập số CMND nhân viên: ");
                    String idCard = SCANNER.nextLine();

                    System.out.print("Nhập số điện thoại nhân viên: ");
                    String phone = SCANNER.nextLine();

                    System.out.print("Nhập email nhân viên: ");
                    String email = SCANNER.nextLine();

                    String level = getLevel();

                    String position = getPosition();

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
                    ReadWriteEmployeeFile.writeEmployeeFile(PATH_EMPLOYEE, employeeList);
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
