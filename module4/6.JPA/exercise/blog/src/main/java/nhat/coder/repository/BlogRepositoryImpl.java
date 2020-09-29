package nhat.coder.repository;

import nhat.coder.model.Blog;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class BlogRepositoryImpl implements BlogRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public List<Blog> getAll() {
        TypedQuery<Blog> query = entityManager.createQuery("SELECT s FROM Blog s", Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findById(Long id) {
        return entityManager.find(Blog.class, id);
    }

    @Override
    public void update(Long id, Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    public void remove(Blog blog) {
        entityManager.remove(entityManager.merge(blog));
    }
}
