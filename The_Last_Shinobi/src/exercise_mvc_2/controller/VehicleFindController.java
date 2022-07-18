package exercise_mvc_2.controller;

import exercise_mvc_2.model.Car;
import exercise_mvc_2.model.Motorbike;
import exercise_mvc_2.model.Truck;
import exercise_mvc_2.service.IVehicleService;
import exercise_mvc_2.service.impl.CarService;
import exercise_mvc_2.service.impl.MotorbikeService;
import exercise_mvc_2.service.impl.TruckService;

import java.util.Scanner;

public class VehicleFindController {
    private final Scanner scanner = new Scanner(System.in);
    private final IVehicleService<Car> car = new CarService();
    private final IVehicleService<Truck> truck = new TruckService();
    private final IVehicleService<Motorbike> motorbike = new MotorbikeService();


    public void menuFindVehicle() {
        do {
            System.out.println("Tìm kiếm phương tiện theo biển kiểm soát: \n" +
                    "1. Tìm kiếm xe tải. \n" +
                    "2. Tìm kiếm ôtô. \n" +
                    "3. Tìm kiếm xe máy. \n" +
                    "4. Quay về menu chính.");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    truck.find();
                    break;
                case 2:
                    car.find();
                    break;
                case 3:
                    motorbike.find();
                    break;
                case 4:
                    return;
            }
        } while (true);
    }
}
