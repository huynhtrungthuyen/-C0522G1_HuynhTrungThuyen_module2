package case_study.utils;

import java.util.Scanner;

public class MenuUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

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

    public static String getLevel() {
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

    public static String getPosition() {
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

    public static String getCustomerType() {
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

    public static String getRentalType() {
        System.out.println("Nhập kiểu thuê:\n" +
                "1. Thuê theo năm.\n" +
                "2. Thuê theo tháng.\n" +
                "3. Thuê theo ngày.\n" +
                "4. Thuê theo giờ.");
        int choose = 0;
        do {
            try {
                choose = Integer.parseInt(SCANNER.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
            switch (choose) {
                case 1:
                    return "Năm";
                case 2:
                    return "Tháng";
                case 3:
                    return "Ngày";
                case 4:
                    return "Giờ";
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng chọn lại!");
            }
        } while (true);
    }
}
