package ss12_map_tree.exercise.array_list.service.impl;

import ss12_map_tree.exercise.array_list.model.Product;

import java.util.Comparator;

public class PriceComparatorDecrease implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o2.getPrice() - o1.getPrice());
    }
}
