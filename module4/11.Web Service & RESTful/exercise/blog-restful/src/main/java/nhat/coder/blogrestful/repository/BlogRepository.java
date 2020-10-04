package nhat.coder.blogrestful.repository;

import nhat.coder.blogpro.model.Blog;
import nhat.coder.blogpro.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    Page<Blog> findByTitleBlogContaining(String search, Pageable pageable);
    List<Blog> findAllByCategory(Category category);
}
