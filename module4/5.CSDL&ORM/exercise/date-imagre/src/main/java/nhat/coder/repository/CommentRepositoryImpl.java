package nhat.coder.repository;

import nhat.coder.model.Comment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository{
    @Override
    public void save(Comment comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.save(comment);

            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Comment> getAll() {
        Session session = null;
        List<Comment> commentList = null;
        try {
            session = ConnectionUtil.getSessionFactory().openSession();
            commentList= session.createQuery("FROM Comment").getResultList();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
        return commentList;
    }
}
