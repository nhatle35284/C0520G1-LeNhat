package nhat.coder.cartsession.service;

import nhat.coder.cartsession.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(Long id);

    void save(Product product);

}
