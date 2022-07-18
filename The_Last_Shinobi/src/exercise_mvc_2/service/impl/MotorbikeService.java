package exercise_mvc_2.service.impl;

import exercise_mvc_2.model.Motorbike;
import exercise_mvc_2.service.IMotorbikeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorbikeService implements IMotorbikeService {
    private static final List<Motorbike> motorbikeList = new ArrayList<>();
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

        System.out.println("Nhập số công suất: ");
        double wattage = Double.parseDouble(scanner.nextLine());

        Motorbike motorbike = new Motorbike(licensePlates, manufacturer, yearOfManufacture, owner, wattage);
        motorbikeList.add(motorbike);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Mời bạn nhập biển kiểm soát cần xóa: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Motorbike motorbike : motorbikeList) {
            if (licensePlatesRemove.equals(motorbike.getLicensePlates())) {
                System.out.println("Bạn có chắc muốn xóa hay không?\n" +
                        "1. Có.\n" +
                        "2. Không.");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    motorbikeList.remove(motorbike);
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
        for (Motorbike motorbike : motorbikeList) {
            System.out.println(motorbike);
        }
    }

    @Override
    public void find() {
        System.out.println("Mời bạn nhập biển kiểm soát cần tìm: ");
        String licensePlatesRemove = scanner.nextLine();
        boolean isExist = false;

        for (Motorbike motorbike : motorbikeList) {
            if (licensePlatesRemove.equals(motorbike.getLicensePlates())) {
                System.out.println(motorbike);
                isExist = true;
                break;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }
}
