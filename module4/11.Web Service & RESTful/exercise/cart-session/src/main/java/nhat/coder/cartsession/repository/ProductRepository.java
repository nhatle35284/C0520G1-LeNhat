package nhat.coder.cartsession.repository;

import nhat.coder.cartsession.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
