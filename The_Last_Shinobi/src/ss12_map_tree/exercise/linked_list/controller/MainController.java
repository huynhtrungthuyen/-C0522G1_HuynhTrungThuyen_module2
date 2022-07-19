package ss12_map_tree.exercise.linked_list.controller;

import ss12_map_tree.exercise.linked_list.service.IProductService;
import ss12_map_tree.exercise.linked_list.service.impl.ProductService;

import java.util.Scanner;

public class MainController {
    public static void menuController() {
        IProductService iProductService = new ProductService();
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nQuản lí sản phẩm:\n" +
                    "1. Thêm sản phẩm.\n" +
                    "2. Sửa thông tin sản phẩm theo id.\n" +
                    "3. Xoá sản phẩm theo id.\n" +
                    "4. Hiển thị danh sách sản phẩm.\n" +
                    "5. Tìm kiếm sản phẩm theo tên.\n" +
                    "6. Sắp xếp sản phẩm tăng dần, giảm dần theo giá.\n" +
                    "7. Thoát chương trình.\n");

            System.out.print("Mời bạn nhập lựa chọn: ");
            int choose = Integer.parseInt(scanner.nextLine());
            switch (choose) {
                case 1:
                    iProductService.add();
                    break;
                case 2:
                    iProductService.set();
                    break;
                case 3:
                    iProductService.remove();
                    break;
                case 4:
                    iProductService.displayAll();
                    break;
                case 5:
                    iProductService.find();
                    break;
                case 6:
                    iProductService.sort();
                    break;
                case 7:
                    System.exit(0);
            }
        } while (true);
    }
}
