package menu.bo;

import menu.dao.IServiceDao;
import menu.dao.ServiceDao;
import menu.model.Service;

public class ServiceBo implements IServiceBo {
    IServiceDao iServiceDao = new ServiceDao();

    @Override
    public void insertService(Service service) {
        iServiceDao.insertService(service);
    }
}
