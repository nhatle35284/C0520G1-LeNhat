package menu.bo.serviceBo;

import menu.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceBo {
    public void insertService(Service service);
    public List<Service> selectAllService();
    public Service getServiceById(String id);
    public void deleteService(int id);
    public void updateService(Service service) throws SQLException;
    public List<Service> searchByName(String name);
}
