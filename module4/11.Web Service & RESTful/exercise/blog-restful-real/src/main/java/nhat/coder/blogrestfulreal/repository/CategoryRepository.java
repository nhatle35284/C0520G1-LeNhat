package nhat.coder.blogrestfulreal.repository;

import nhat.coder.blogrestfulreal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
