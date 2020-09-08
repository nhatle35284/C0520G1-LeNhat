package menu.bo.customerBo;

import menu.dao.customerDao.CustomerDao;
import menu.dao.customerDao.ICustomerDao;
import menu.model.Customer;
import menu.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class CustomerBo implements ICustomerBo {
    ICustomerDao iCustomerDao = new CustomerDao();

    @Override
    public List<Customer> selectAllCustomer() {
        return iCustomerDao.selectAllCustomer();
    }

    @Override
    public void insertCustomer(Customer customer) {
        iCustomerDao.insertCustomer(customer);
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        iCustomerDao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return iCustomerDao.getCustomerById(id);
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        iCustomerDao.deleteCustomer(id);
    }

    @Override
    public List<Customer> searchByName(String name) {
        return iCustomerDao.searchByName(name);
    }
}
