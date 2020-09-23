package nhat.coder.repository;

import nhat.coder.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer,Product> products;

    static {
        products = new TreeMap<>();
        products.put(1,new Product(1,"SamSung Galaxy Note 10",1200,"SamSung"));
        products.put(2,new Product(2,"SamSung Galaxy Note 8",800,"SamSung"));
        products.put(3,new Product(3,"Iphone X",1100,"Apple"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }
}
