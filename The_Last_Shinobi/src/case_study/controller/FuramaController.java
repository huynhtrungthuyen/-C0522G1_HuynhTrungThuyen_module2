package case_study.controller;

import java.util.Scanner;

public class FuramaController {
    public static void displayMainMenu() {
        EmployeeController employeeController = new EmployeeController();
        CustomerController customerController = new CustomerController();
        FacilityController facilityController = new FacilityController();
        BookingController bookingController = new BookingController();
        PromotionController promotionController = new PromotionController();

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("FURAMA MANAGEMENT MENU:.\n" +
                    "1. Employee Management.\n" +
                    "2. Customer Management.\n" +
                    "3. Facility Management.\n" +
                    "4. Booking Management.\n" +
                    "5. Promotion Management.\n" +
                    "6. Exit.");

            System.out.print("Mời bạn nhập lựa chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());

            switch (choose) {
                case 1:
                    employeeController.menuEmployeeManagement();
                    break;
                case 2:
                    customerController.menuCustomerManagement();
                    break;
                case 3:
                    facilityController.menuFacilityManagement();
                    break;
                case 4:
                    bookingController.menuBookingManagement();
                    break;
                case 5:
                    promotionController.menuPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
            }
        } while (true);
    }
}
