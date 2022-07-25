package ss17_io_binary_file_serialization.exercise.read_write_binary_file.controller;

import ss17_io_binary_file_serialization.exercise.read_write_binary_file.model.Product;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.service.IProductService;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.service.impl.ProductService;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.utils.ReadWriteProductFileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    public static void menuController() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone 6s", "Apple", 3000000));
        ReadWriteProductFileUtil.writeProductFile("src/ss17_io_binary_file_serialization/exercise/read_write_binary_file/data/product.csv", productList);
        Scanner scanner = new Scanner(System.in);
        IProductService iProductService = new ProductService();
        do {
            System.out.println("QUẢN LÝ SẢN PHẨM:\n" +
                    "1. Thêm sản phẩm.\n" +
                    "2. Hiển thị sản phẩm.\n" +
                    "3. Tìm kiếm sản phẩm.\n" +
                    "4. Thoát.");

            int choose = 0;
            try {
                System.out.print("Mời bạn nhập lựa chọn: ");
                choose = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }

            switch (choose) {
                case 1:
                    iProductService.add();
                    break;
                case 2:
                    iProductService.display();
                    break;
                case 3:
                    iProductService.findByName();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn của bạn không tồn tại, vui lòng nhập lại!");
            }
        } while (true);
    }
}
