package exercise2.controller;

import exercise2.model.Car;
import exercise2.model.Motorbike;
import exercise2.model.Truck;
import exercise2.service.IVehicleService;
import exercise2.service.impl.CarService;
import exercise2.service.impl.MotorbikeService;
import exercise2.service.impl.TruckService;

import java.util.Scanner;

public class VehicleRemoveController {
    private final Scanner scanner = new Scanner(System.in);
    private final IVehicleService<Car> car = new CarService();
    private final IVehicleService<Truck> truck = new TruckService();
    private final IVehicleService<Motorbike> motorbike = new MotorbikeService();


    public void menuRemoveVehicle() {
        do {
            System.out.println("Xóa phương tiện: \n" +
                    "1. Xóa xe tải. \n" +
                    "2. Xóa ôtô. \n" +
                    "3. Xóa xe máy. \n" +
                    "4. Quay về menu chính.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    truck.remove();
                    break;
                case 2:
                    car.remove();
                    break;
                case 3:
                    motorbike.remove();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }
}
