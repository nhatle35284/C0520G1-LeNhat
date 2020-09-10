package menu.bo.serviceBo;

import menu.dao.serviceDao.IServiceDao;
import menu.dao.serviceDao.ServiceDao;
import menu.model.Service;

import java.sql.SQLException;
import java.util.List;

public class ServiceBo implements IServiceBo {
    IServiceDao iServiceDao = new ServiceDao();

    @Override
    public void insertService(Service service) {
        iServiceDao.insertService(service);
    }

    @Override
    public List<Service> selectAllService() {
        return iServiceDao.selectAllService();
    }

    @Override
    public Service getServiceById(String id) {
        return iServiceDao.getServiceById(id);
    }

    @Override
    public void deleteService(String id) {
        iServiceDao.deleteService(id);
    }

    @Override
    public void updateService(Service service) throws SQLException {
        iServiceDao.updateService(service);
    }

    @Override
    public List<Service> searchByName(String name) {
        return iServiceDao.searchByName(name);
    }
}
