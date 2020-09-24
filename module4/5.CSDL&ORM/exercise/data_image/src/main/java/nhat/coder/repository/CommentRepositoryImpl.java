package nhat.coder.repository;

import nhat.coder.model.Test;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository{
    @Override
    public void save(Test comment) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = Connection.sessionFactory.openSession();
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
    public List<Test> getAll() {
        Session session = null;
        List<Test> commentList = null;
        try {
            session = Connection.sessionFactory.openSession();
            commentList= session.createQuery("FROM zzzxx").getResultList();
        }
        finally {
            if (session!=null){
                session.close();
            }
        }
        return commentList;
    }
}
