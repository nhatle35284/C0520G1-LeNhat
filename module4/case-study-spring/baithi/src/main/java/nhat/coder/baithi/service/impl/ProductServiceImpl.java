package nhat.coder.baithi.service.impl;

import nhat.coder.baithi.model.Product;
import nhat.coder.baithi.repository.ProductRepository;
import nhat.coder.baithi.service.ProductService;
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
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Page<Product> findAllByProductId(String search,Pageable pageable) {
        return productRepository.findAllByProductIdContaining(search,pageable);
    }

    @Override
    public Page<Product> findAllByProductName(String search,Pageable pageable) {
        return productRepository.findAllByProductNameContaining(search,pageable);
    }

    @Override
    public Page<Product> findAllByColor(String search,Pageable pageable) {
        return productRepository.findAllByColorContaining(search,pageable);
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
        Product product= productRepository.findById(id).orElse(null);
        product.setStatus(false);
        productRepository.save(product);
    }

    @Override
    public Page<Product> findAllByStatusTrue(Pageable pageable) {
        return productRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public Page<Product> findAllByProductNameContainingOrColorContaining(String name, String color, Pageable pageable) {
        return productRepository.findAllByProductNameContainingOrColorContaining(name,name,pageable);
    }

    @Override
    public List<Product> findByStatusTrueOrOrderByProductNameDesc() {
        return productRepository.findByStatusTrueOrderByProductNameDesc();
    }


//    @Override
//    public List<Product> findAllByOrOrderByProductNameDesc() {
//        return productRepository.findAllByProductNameOrOrderByProductNameDesc();
//    }
}
