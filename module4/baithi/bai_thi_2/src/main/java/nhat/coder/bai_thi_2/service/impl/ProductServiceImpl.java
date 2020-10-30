package nhat.coder.bai_thi_2.service.impl;

import nhat.coder.bai_thi_2.model.Product;
import nhat.coder.bai_thi_2.repository.ProductRepository;
import nhat.coder.bai_thi_2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
        productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<Product> findAllByProductNameContaining(String name,Pageable pageable) {
        return productRepository.findAllByProductNameContaining(name,pageable);
    }

    @Override
    public Page<Product> findByPrice(String price, Pageable pageable) {
        return productRepository.findAllByPriceContaining(price,pageable);
    }

    @Override
    public Page<Product> findAllByCategory(String category, Pageable pageable) {
        return productRepository.findAllByCategoryContaining(category,pageable);
    }


}
