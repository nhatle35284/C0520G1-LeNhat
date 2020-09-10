package menu.bo.customerBo;

import menu.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerBo {
    List<Customer> selectAllCustomer();
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer) throws SQLException;
    public  Customer getCustomerById(String id);
    void deleteCustomer(String id) throws SQLException;
    public List<Customer> searchByName(String name);
}
