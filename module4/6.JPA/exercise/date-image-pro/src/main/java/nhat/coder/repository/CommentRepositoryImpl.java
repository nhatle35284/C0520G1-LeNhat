package nhat.coder.repository;

import nhat.coder.model.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class CommentRepositoryImpl implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }

    @Override
    public List<Comment> getAll() {
        TypedQuery<Comment> query = entityManager.createQuery("SELECT s FROM Comment s", Comment.class);
        return query.getResultList();
    }

    @Override
    public Comment findById(int id) {
        return entityManager.find(Comment.class,id);
    }

    @Override
    public void update(int id, Comment comment) {
        entityManager.merge(comment);
    }
}
