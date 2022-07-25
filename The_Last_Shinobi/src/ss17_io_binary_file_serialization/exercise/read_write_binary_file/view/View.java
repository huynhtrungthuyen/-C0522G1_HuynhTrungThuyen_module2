package ss17_io_binary_file_serialization.exercise.read_write_binary_file.view;

import ss17_io_binary_file_serialization.exercise.read_write_binary_file.controller.MainController;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.model.Product;
import ss17_io_binary_file_serialization.exercise.read_write_binary_file.utils.ReadWriteProductFile;

import java.util.ArrayList;
import java.util.List;

public class View {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "Iphone 6s", "Apple", 3000000));
        ReadWriteProductFile.writeProductFile("src/ss17_io_binary_file_serialization/exercise/read_write_binary_file/data/product.csv", productList);
        MainController.menuController();
    }
}
