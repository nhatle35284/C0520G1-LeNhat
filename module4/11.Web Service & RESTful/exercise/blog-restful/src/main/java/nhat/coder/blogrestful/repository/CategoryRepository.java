package nhat.coder.blogrestful.repository;

import nhat.coder.blogpro.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
