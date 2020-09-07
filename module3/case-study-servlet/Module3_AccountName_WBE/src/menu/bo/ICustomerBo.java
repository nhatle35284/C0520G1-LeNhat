package menu.bo;

import menu.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerBo {
    List<Customer> selectAllCustomer();
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer) throws SQLException;
    public  Customer getCustomerById(int id);
    void deleteCustomer(int id) throws SQLException;
}
