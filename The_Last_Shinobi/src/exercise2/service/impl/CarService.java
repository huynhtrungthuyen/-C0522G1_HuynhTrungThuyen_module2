package exercise2.service.impl;

import exercise2.model.Car;
import exercise2.service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    private static final List<Car> carList = new ArrayList<>();
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

        System.out.println("Nhập số chỗ ngồi: ");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập kiểu xe: ");
        String carType = scanner.nextLine();

        Car car = new Car(licensePlates, manufacturer, yearOfManufacture, owner, numberOfSeats, carType);
        carList.add(car);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập biển kiểm soát cần xóa: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Car car : carList) {
            if (licensePlatesRemove.equals(car.getLicensePlates())) {
                System.out.println("Bạn có chắc muốn xóa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    carList.remove(car);
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
        for (Car car : carList) {
            System.out.println(car);
        }
    }

    @Override
    public void find() {
        System.out.println("Mời bạn nhập biển kiểm soát cần tìm: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Car car : carList) {
            if (licensePlatesRemove.equals(car.getLicensePlates())) {
                System.out.println(car);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }
}
