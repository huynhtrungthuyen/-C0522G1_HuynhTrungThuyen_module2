package case_study.service.impl;

import case_study.model.Customer;
import case_study.service.ICustomerService;
import case_study.utils.MenuUtil;
import case_study.utils.ReadWriteCustomerFileUtil;
import case_study.utils.RegexExceptionUtil;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private static final String PATH_CUSTOMER = "src/case_study/data/customer.csv";
    private static final Scanner SCANNER = new Scanner(System.in);

    @Override
    public void add() {
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(PATH_CUSTOMER);
        System.out.print("Nhập mã số khách hàng: ");
        boolean isExistId;
        String id;
        do {
            isExistId = false;
            id = SCANNER.nextLine();
            for (Customer customer : customerList) {
                if (id.equals(customer.getId())) {
                    System.out.println("Mã khách hàng đã tồn tại, vui lòng nhập lại!");
                    isExistId = true;
                    break;
                }
            }
        } while (isExistId);

        System.out.print("Nhập tên khách hàng: ");
        String name = SCANNER.nextLine();

        String dateOfBirth = RegexExceptionUtil.getDateOfBirth();

        String gender = MenuUtil.getGender();

        System.out.print("Nhập số CMND khách hàng: ");
        String idCard = SCANNER.nextLine();

        System.out.print("Nhập số điện thoại khách hàng: ");
        String phone = SCANNER.nextLine();

        System.out.print("Nhập email khách hàng: ");
        String email = SCANNER.nextLine();

        String customerType = MenuUtil.getCustomerType();

        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = SCANNER.nextLine();

        customerList.add(new Customer(id, name, dateOfBirth, gender, idCard, phone, email, customerType, address));
        ReadWriteCustomerFileUtil.writeCustomerFile(PATH_CUSTOMER, customerList);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void display() {
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(PATH_CUSTOMER);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void edit() {
        List<Customer> customerList = ReadWriteCustomerFileUtil.readCustomerFile(PATH_CUSTOMER);
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

                    String gender = MenuUtil.getGender();

                    System.out.print("Nhập số CMND khách hàng: ");
                    String idCard = SCANNER.nextLine();

                    System.out.print("Nhập số điện thoại khách hàng: ");
                    String phone = SCANNER.nextLine();

                    System.out.print("Nhập email khách hàng: ");
                    String email = SCANNER.nextLine();

                    String customerType = MenuUtil.getCustomerType();

                    System.out.print("Nhập địa chỉ khách hàng: ");
                    String address = SCANNER.nextLine();

                    customerList.set(i, new Customer(idEdit, name, dateOfBirth, gender, idCard, phone, email, customerType, address));
                    ReadWriteCustomerFileUtil.writeCustomerFile(PATH_CUSTOMER, customerList);
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
