package nhat.coder.baithi.repository;

import nhat.coder.baithi.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    Page<Product> findAllByProductIdContaining(String search,Pageable pageable);
    Page<Product> findAllByProductNameContaining(String search,Pageable pageable);
    Page<Product> findAllByColorContaining(String search,Pageable pageable);
    Page<Product> findAllByStatusTrue(Pageable pageable);
//    Page<Product> findAllByStatusTrueOrderByProductNameDesc();
    List<Product> findByStatusTrueOrderByProductNameDesc();
}


