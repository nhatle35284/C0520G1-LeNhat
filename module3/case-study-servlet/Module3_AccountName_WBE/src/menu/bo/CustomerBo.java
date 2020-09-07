package menu.bo;

import menu.dao.CustomerDao;
import menu.dao.ICustomerDao;
import menu.model.Customer;

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
}
