package menu.dao.customerUserService;

import menu.model.CustomerUserService;
import menu.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerUserServiceDao {
    public List<CustomerUserService> selectCustomerUserService();

    public List<Service> selectAllService();

    void deleteCustomerUserService(int id) throws SQLException;

}
