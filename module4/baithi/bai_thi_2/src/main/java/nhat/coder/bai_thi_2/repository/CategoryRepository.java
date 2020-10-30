package nhat.coder.bai_thi_2.repository;

import nhat.coder.bai_thi_2.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
}
