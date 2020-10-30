package nhat.coder.bai_thi_2.service;

import nhat.coder.bai_thi_2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    Page<Product> findAll(Pageable pageable);

//    Page<Product> findAllByProductId(String search, Pageable pageable);
//    Page<Product> findAllByProductName(String search, Pageable pageable);
//    Page<Product> findAllByColor(String search, Pageable pageable);

    void save(Product product);

    Product findById(Long id);

    void update(Product product);

    void remove(Long id);

    Page<Product> findAllByProductNameContaining(String name,Pageable pageable);
    Page<Product> findByPrice(String price,Pageable pageable);
    Page<Product> findAllByCategory(String category,Pageable pageable);




}
