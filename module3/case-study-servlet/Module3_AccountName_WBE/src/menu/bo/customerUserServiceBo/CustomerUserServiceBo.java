package menu.bo.customerUserServiceBo;

import menu.dao.customerUserService.CustomerUserServiceDao;
import menu.dao.customerUserService.ICustomerUserServiceDao;
import menu.model.CustomerUserService;

import java.util.List;

public class CustomerUserServiceBo implements ICustomerUserServiceBo {
    ICustomerUserServiceDao iCustomerUserServiceDao = new CustomerUserServiceDao();

    @Override
    public List<CustomerUserService> selectCustomerUserService() {
        return iCustomerUserServiceDao.selectCustomerUserService();
    }
}
