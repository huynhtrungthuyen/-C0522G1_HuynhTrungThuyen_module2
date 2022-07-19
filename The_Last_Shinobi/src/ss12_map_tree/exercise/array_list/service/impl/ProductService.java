package ss12_map_tree.exercise.array_list.service.impl;

import ss12_map_tree.exercise.array_list.model.Product;
import ss12_map_tree.exercise.array_list.service.IProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<Product> PRODUCT_LIST = new ArrayList<>();

    static {
        PRODUCT_LIST.add(new Product(1, "Trứng gà công nghiệp", 5000));
        PRODUCT_LIST.add(new Product(2, "Trứng gà ta", 6000));
        PRODUCT_LIST.add(new Product(3, "Xúc xích", 10000));
        PRODUCT_LIST.add(new Product(4, "Kẹo mút", 3000));
        PRODUCT_LIST.add(new Product(5, "Gà khỏa thân", 150000));
    }

    @Override
    public void add() {
        System.out.print("Nhập id sản phẩm: ");
        int id = Integer.parseInt(SCANNER.nextLine());

        System.out.print("Nhập tên sản phẩm: ");
        String name = SCANNER.nextLine();

        System.out.print("Nhập giá sản phẩm (VNĐ): ");
        int price = Integer.parseInt(SCANNER.nextLine());

        PRODUCT_LIST.add(new Product(id, name, price));
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        int idRemove = Integer.parseInt(SCANNER.nextLine());
        boolean isExist = false;

        for (Product product : PRODUCT_LIST) {
            if (product.getId() == idRemove) {
                System.out.println("Bạn có chắc muốn xóa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    PRODUCT_LIST.remove(product);
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
        for (Product product : PRODUCT_LIST) {
            System.out.println(product);
        }
    }

    @Override
    public void find() {
        System.out.println("Nhập tên sản phẩm cần tìm: ");
        String nameFind = SCANNER.nextLine();
        boolean isExist = false;

        for (Product product : PRODUCT_LIST) {
            if (product.getName().toLowerCase().contains(nameFind.toLowerCase())) {
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
        System.out.println("Nhập id sản phẩm cần chỉnh sửa: ");
        int idSet = Integer.parseInt(SCANNER.nextLine());
        boolean isExist = false;

        for (int i = 0; i < PRODUCT_LIST.size(); i++) {
            if (PRODUCT_LIST.get(i).getId() == idSet) {
                System.out.println("Sản phẩm cần chỉnh sửa: \n" + PRODUCT_LIST.get(i));
                System.out.println("Bạn có chắc muốn sửa hay không? \n" +
                        "1. Có \n" +
                        "2. Không");
                int chooseYesNo = Integer.parseInt(SCANNER.nextLine());

                if (chooseYesNo == 1) {
                    System.out.print("Nhập tên mới: ");
                    String name = SCANNER.nextLine();

                    System.out.print("Nhập giá mới (VNĐ): ");
                    int price = Integer.parseInt(SCANNER.nextLine());

                    PRODUCT_LIST.set(i, new Product(PRODUCT_LIST.get(i).getId(), name, price));
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
            choose = Integer.parseInt(SCANNER.nextLine());

            if (choose != 1 && choose != 2) {
                System.out.println("Nhập lại!");
            }
        } while (choose != 1 && choose != 2);

        PriceComparatorAscending priceComparatorAscending = new PriceComparatorAscending();
        PriceComparatorDecrease priceComparatorDecrease = new PriceComparatorDecrease();
        if (choose == 1) {
            PRODUCT_LIST.sort(priceComparatorAscending);
            System.out.println("Sắp xếp sản phẩm theo giá tăng dần: ");
        } else {
            PRODUCT_LIST.sort(priceComparatorDecrease);
            System.out.println("Sắp xếp sản phẩm theo giá giảm dần: ");
        }

        for (Product product : PRODUCT_LIST) {
            System.out.println(product);
        }
    }
}
