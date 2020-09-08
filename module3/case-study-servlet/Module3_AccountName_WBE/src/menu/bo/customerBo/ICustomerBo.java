package menu.bo.customerBo;

import menu.model.Customer;
import menu.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerBo {
    List<Customer> selectAllCustomer();
    void insertCustomer(Customer customer);
    void updateCustomer(Customer customer) throws SQLException;
    public  Customer getCustomerById(int id);
    void deleteCustomer(int id) throws SQLException;
    public List<Customer> searchByName(String name);
}
