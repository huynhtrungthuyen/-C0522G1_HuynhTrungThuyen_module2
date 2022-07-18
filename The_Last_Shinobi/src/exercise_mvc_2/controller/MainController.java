package exercise_mvc_2.controller;

import java.util.Scanner;

public class MainController {
    public static void menuController() {
        VehicleAddController vehicleAddController = new VehicleAddController();
        VehicleDisplayController vehicleDisplayController = new VehicleDisplayController();
        VehicleRemoveController vehicleRemoveController = new VehicleRemoveController();
        VehicleFindController vehicleFindController = new VehicleFindController();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n" +
                    "Chọn chức năng:\n" +
                    "1. Thêm mới phương tiện.\n" +
                    "2. Hiển thị phương tiện.\n" +
                    "3. Xóa phương tiện.\n" +
                    "4. Tìm kiểm theo biển kiểm soát.\n" +
                    "5. Thoát.");

            System.out.print("Mời bạn nhập lựa chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    vehicleAddController.menuAddVehicle();
                    break;
                case 2:
                    vehicleDisplayController.menuDisplayVehicle();
                    break;
                case 3:
                    vehicleRemoveController.menuRemoveVehicle();
                    break;
                case 4:
                    vehicleFindController.menuFindVehicle();
                    break;
                case 5:
                    System.exit(0);
            }
        } while (true);
    }
}
