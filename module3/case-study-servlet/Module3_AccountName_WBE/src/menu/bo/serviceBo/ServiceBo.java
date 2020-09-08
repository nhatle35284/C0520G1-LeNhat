package menu.bo.serviceBo;

import menu.dao.serviceDao.IServiceDao;
import menu.dao.serviceDao.ServiceDao;
import menu.model.Service;

public class ServiceBo implements IServiceBo {
    IServiceDao iServiceDao = new ServiceDao();

    @Override
    public void insertService(Service service) {
        iServiceDao.insertService(service);
    }
}
