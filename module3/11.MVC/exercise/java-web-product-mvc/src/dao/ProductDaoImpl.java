package dao;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDaoImpl implements ProductDao{
    private static Map<Integer, Product> productMap = new HashMap<>();

    static {
        productMap.put(1, new Product(1, "SamSung"));
        productMap.put(2, new Product(2, "Iphone"));
        productMap.put(3, new Product(3, "Oppo"));
        productMap.put(4, new Product(4, "Xiaomi"));
    }



    @Override
    public List<Product> getListProduct() {
        return new ArrayList<>(productMap.values());
    }
    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void deleteById(int id) {
        productMap.remove(id);
    }
    @Override
    public List<Product> findByName(String name) {
        List<Product> listProduct = new ArrayList<>(productMap.values());
        List<Product> product = new ArrayList<>();
        for (int i=0;i<listProduct.size();i++){
            if (name.contains(listProduct.get(i).getName())){
                product.add(listProduct.get(i));
            }
        }
        return product;
    }
}
