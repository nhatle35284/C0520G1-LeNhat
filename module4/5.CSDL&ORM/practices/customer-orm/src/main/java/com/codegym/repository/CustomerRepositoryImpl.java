package com.codegym.repository;

import com.codegym.model.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private static Map<Integer, Customer> customers;

    static {

        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> findAll() {
        Session session = null;
        List<Customer> customerList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            customerList = session.createQuery("FROM Customer").getResultList();

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {
            Session session = null;
            Transaction transaction = null;
            try {
                session = ConnectionUtil.sessionFactory.openSession();
                transaction = session.beginTransaction();

                session.save(customer);

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
    public Customer findById(int id) {
        Session session = null;
        Customer customer = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();

            customer = session.get(Customer.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return customer;
    }

    @Override
    public void update(int id, Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(customer);

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
    public void remove(int id,Customer customer) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.delete(customer);

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
}
