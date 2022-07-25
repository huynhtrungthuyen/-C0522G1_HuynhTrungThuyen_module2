package case_study.service.impl;

import case_study.model.Customer;
import case_study.service.ICustomerService;
import case_study.utils.ReadWriteCustomerFile;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final String PATH_CUSTOMER = "src/case_study/data/customer.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    private String getGender() {
        System.out.println("Nhập giới tính khách hàng:\n" +
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

    private String getCustomerType() {
        System.out.println("Nhập loại khách hàng:\n" +
                "1. Kim cương.\n" +
                "2. Bạch kim.\n" +
                "3. Vàng.\n" +
                "4. Bạc.\n" +
                "5. Thành viên.");
        int choose = 0;
        do {
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    return "Kim cương";
                case 2:
                    return "Bạch kim";
                case 3:
                    return "Vàng";
                case 4:
                    return "Bạc";
                case 5:
                    return "Thành viên";
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng chọn lại!");
            }
        } while (true);
    }

    @Override
    public void add() {
        List<Customer> customerList = ReadWriteCustomerFile.readCustomerFile(PATH_CUSTOMER);
        System.out.print("Nhập mã số khách hàng: ");
        boolean isExistId;
        String id;
        do {
            isExistId = false;
            id = SCANNER.nextLine();
            for (Customer customer : customerList) {
                if (id.equals(customer.getId())) {
                    isExistId = true;
                    break;
                }
            }
        } while (isExistId);

        System.out.print("Nhập tên khách hàng: ");
        String name = SCANNER.nextLine();

        System.out.print("Nhập ngày sinh khách hàng: ");
        String dateOfBirth = SCANNER.nextLine();

        String gender = getGender();

        System.out.print("Nhập số CMND khách hàng: ");
        String idCard = SCANNER.nextLine();

        System.out.print("Nhập số điện thoại khách hàng: ");
        String phone = SCANNER.nextLine();

        System.out.print("Nhập email khách hàng: ");
        String email = SCANNER.nextLine();

        String customerType = getCustomerType();

        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = SCANNER.nextLine();

        customerList.add(new Customer(id, name, dateOfBirth, gender, idCard, phone, email, customerType, address));
        ReadWriteCustomerFile.writeCustomerFile(PATH_CUSTOMER, customerList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        List<Customer> customerList = ReadWriteCustomerFile.readCustomerFile(PATH_CUSTOMER);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        List<Customer> customerList = ReadWriteCustomerFile.readCustomerFile(PATH_CUSTOMER);
        System.out.print("Nhập mã số khách hàng cần chỉnh sửa: ");
        String idEdit = SCANNER.nextLine();
        boolean isExist = false;

        for (int i = 0; i < customerList.size(); i++) {
            if (idEdit.equals((customerList.get(i).getId()))) {
                System.out.println("Khách hàng muốn chỉnh sửa: ");
                System.out.println(customerList.get(i));
                System.out.println("Bạn có chắc muốn chỉnh sửa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    System.out.print("Nhập tên khách hàng: ");
                    String name = SCANNER.nextLine();

                    System.out.print("Nhập ngày sinh khách hàng: ");
                    String dateOfBirth = SCANNER.nextLine();

                    String gender = getGender();

                    System.out.print("Nhập số CMND khách hàng: ");
                    String idCard = SCANNER.nextLine();

                    System.out.print("Nhập số điện thoại khách hàng: ");
                    String phone = SCANNER.nextLine();

                    System.out.print("Nhập email khách hàng: ");
                    String email = SCANNER.nextLine();

                    String customerType = getCustomerType();

                    System.out.print("Nhập địa chỉ khách hàng: ");
                    String address = SCANNER.nextLine();

                    customerList.set(i, new Customer(idEdit, name, dateOfBirth, gender, idCard, phone, email, customerType, address));
                    ReadWriteCustomerFile.writeCustomerFile(PATH_CUSTOMER, customerList);
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
