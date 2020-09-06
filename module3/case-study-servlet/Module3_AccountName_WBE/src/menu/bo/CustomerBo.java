package menu.bo;

import menu.dao.CustomerDao;
import menu.dao.ICustomerDao;
import menu.model.Customer;

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
}
