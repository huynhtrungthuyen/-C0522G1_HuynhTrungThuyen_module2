package ss12_map_tree.exercise.array_list.service.impl;

import ss12_map_tree.exercise.array_list.model.Product;
import ss12_map_tree.exercise.array_list.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Product> productList = new ArrayList<>();

    @Override
    public void add() {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        String name = scanner.nextLine();

        System.out.print("Nhập giá sản phẩm: ");
        double price = Double.parseDouble(scanner.nextLine());

        Product product = new Product(id, name, price);
        productList.add(product);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        int idRemove = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (Product product : productList) {
            if (product.getId() == idRemove) {
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    productList.remove(product);
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
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    @Override
    public void find() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String nameFind = scanner.nextLine();
        boolean isExist = false;

        for (Product product : productList) {
            if (nameFind.equals(product.getName())) {
                System.out.println(product);
                isExist = true;
            }
        }

        if (!isExist) {
            System.out.println("Không tìm thấy!");
        }
    }

    @Override
    public void set() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        int idSet = Integer.parseInt(scanner.nextLine());
        boolean isExist = false;

        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == idSet) {
                System.out.println("Bạn có chắc muốn sửa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(scanner.nextLine());

                if (chooseYesNo == 1) {
                    System.out.print("Nhập tên mới: ");
                    String name = scanner.nextLine();

                    System.out.print("Nhập giá mới: ");
                    double price = Double.parseDouble(scanner.nextLine());

                    Product product = new Product(productList.get(i).getId(), name, price);
                    productList.set(i, product);
                    System.out.println("Chỉnh sửa thành công!");
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
    public void sort() {
        int choose;
        do {
            System.out.println("Sắp xếp: \n" +
                    "1. Tăng dần.\n" +
                    "2. Giảm dần.");
            choose = Integer.parseInt(scanner.nextLine());

            if (choose != 1 && choose != 2) {
                System.out.println("Nhập lại!");
            }
        } while (choose != 1 && choose != 2);

        PriceComparatorAscending priceComparatorAscending = new PriceComparatorAscending();
        PriceComparatorDecrease priceComparatorDecrease = new PriceComparatorDecrease();
        if (choose == 1) {
            productList.sort(priceComparatorAscending);
            System.out.println("Sắp xếp sản phẩm theo giá tăng dần: ");
        } else {
            productList.sort(priceComparatorDecrease);
            System.out.println("Sắp xếp sản phẩm theo giá giảm dần: ");
        }

        for (Product product : productList) {
            System.out.println(product);
        }
    }
}
