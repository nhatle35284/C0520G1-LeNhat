package nhat.coder.bai_thi_2.repository;

import nhat.coder.bai_thi_2.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
     Page<Product> findAllByProductNameContaining(String name,Pageable pageable);
     Page<Product> findAllByPriceContaining(String price,Pageable pageable);
     Page<Product> findAllByCategoryContaining(String category,Pageable pageable);}


