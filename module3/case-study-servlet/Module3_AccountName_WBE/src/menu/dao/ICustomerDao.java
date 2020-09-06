package menu.dao;

import menu.model.Customer;

import java.util.List;

public interface ICustomerDao {
    void insertCustomer(Customer customer);

    public List<Customer> selectAllCustomer();
}
