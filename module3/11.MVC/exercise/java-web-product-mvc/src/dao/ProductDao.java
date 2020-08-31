package dao;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDao {
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "SamSung"));
        productMap.put(2, new Product(2, "Iphone"));
        productMap.put(3, new Product(3, "Oppo"));
        productMap.put(4, new Product(4, "Xiaomi"));
    }

    public static List<Product> getListStudent() {
        return new ArrayList<>(productMap.values());
    }

    public static void save(Product product) {
        productMap.put(product.getId(), product);
    }

    public static Product findById(Integer id) {
        return productMap.get(id);
    }

    public static void deleteById(Integer id) {
        productMap.remove(id);
    }

    public static Product findByName(String name) {
        for (Map.Entry<Integer, Product> entry : productMap.entrySet()) {
            if (name.equals(entry.getValue().getName())) {
                System.out.println(entry.getKey() + "/" + entry.getValue());
            }
        }
        return null;
    }
}
