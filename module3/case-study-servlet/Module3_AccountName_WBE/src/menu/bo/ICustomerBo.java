package menu.bo;

import menu.model.Customer;

import java.util.List;

public interface ICustomerBo {
    List<Customer> selectAllCustomer();
    void insertCustomer(Customer customer);
}
