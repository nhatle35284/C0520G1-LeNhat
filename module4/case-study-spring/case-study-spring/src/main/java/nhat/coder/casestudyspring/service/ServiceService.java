package nhat.coder.casestudyspring.service;

import nhat.coder.casestudyspring.model.Employee;
import nhat.coder.casestudyspring.model.Service;

import java.util.List;

public interface ServiceService {
    List<Service> findAll();

    void save(Service service);

    Service findById(String id);

    void update(Service service);

    void remove(String id);
}
