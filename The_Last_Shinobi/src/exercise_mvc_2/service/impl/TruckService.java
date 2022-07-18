package exercise_mvc_2.service.impl;

import exercise_mvc_2.model.Truck;
import exercise_mvc_2.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static final List<Truck> truckList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void add() {
        System.out.print("Nhập biển kiểm soát: ");
        String licensePlates = scanner.nextLine();

        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = scanner.nextLine();

        System.out.print("Nhập năm sản xuất: ");
        int yearOfManufacture = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập chủ sở hữu: ");
        String owner = scanner.nextLine();

        System.out.print("Nhập trọng tải (tấn): ");
        double tonnage = Double.parseDouble(scanner.nextLine());

        Truck truck = new Truck(licensePlates, manufacturer, yearOfManufacture, owner, tonnage);
        truckList.add(truck);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập biển kiểm soát cần xóa: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Truck truck : truckList) {
            if (licensePlatesRemove.equals(truck.getLicensePlates())) {
                System.out.println("Bạn có chắc muốn xóa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    truckList.remove(truck);
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
        for (Truck truck : truckList) {
            System.out.println(truck);
        }
    }

    @Override
    public void find() {
        System.out.println("Mời bạn nhập biển kiểm soát cần tìm: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Truck truck : truckList) {
            if (licensePlatesRemove.equals(truck.getLicensePlates())) {
                System.out.println(truck);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }
}
