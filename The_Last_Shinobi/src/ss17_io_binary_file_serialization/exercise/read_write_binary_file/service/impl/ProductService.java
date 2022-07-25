package ss17_io_binary_file_serialization.exercise.read_write_binary_file.service.impl;

import ss17_io_binary_file_serialization.exercise.read_write_binary_file.exception.DuplicateIDException;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.model.Product;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.service.IProductService;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.utils.ReadWriteProductFileUtil;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PATH = "src/ss17_io_binary_file_serialization/exercise/read_write_binary_file/data/product.csv";

    @Override
    public void add() {
        List<Product> productList = ReadWriteProductFileUtil.readProductFile(PATH);

        int id;
        while (true) {
            try {
                System.out.print("Nhập id: ");
                id = Integer.parseInt(SCANNER.nextLine());

                for (Product product : productList) {
                    if (product.getId() == id) {
                        throw new DuplicateIDException("Trùng id, vui lòng nhập lại!");
                    }
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            } catch (DuplicateIDException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        String name = SCANNER.nextLine();

        System.out.print("Nhập hãng sản xuất: ");
        String manufacturer = SCANNER.nextLine();

        int price;
        while (true) {
            try {
                System.out.print("Nhập giá sản phẩm (VNĐ): ");
                price = Integer.parseInt(SCANNER.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }

        productList.add(new Product(id, name, manufacturer, price));
        ReadWriteProductFileUtil.writeProductFile(PATH, productList);
        System.out.println("Thêm sản phẩm thành công!");
    }

    @Override
    public void display() {
        List<Product> productList = ReadWriteProductFileUtil.readProductFile(PATH);
        System.out.println("Danh sách sản phẩm: ");
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void findByName() {
        List<Product> productList = ReadWriteProductFileUtil.readProductFile(PATH);
        System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
        String nameFind = SCANNER.nextLine();
        boolean isExist = false;

        for (Product product : productList) {
            if (product.getName().toLowerCase().contains(nameFind.toLowerCase())) {
                System.out.println(product);
                isExist = true;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
}
