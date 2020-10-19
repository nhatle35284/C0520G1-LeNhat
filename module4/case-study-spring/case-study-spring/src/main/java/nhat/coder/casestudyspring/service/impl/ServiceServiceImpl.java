package nhat.coder.casestudyspring.service.impl;

import nhat.coder.casestudyspring.repository.ServiceRepository;
import nhat.coder.casestudyspring.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<nhat.coder.casestudyspring.model.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(nhat.coder.casestudyspring.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public nhat.coder.casestudyspring.model.Service findById(String id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public void update(nhat.coder.casestudyspring.model.Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(String id) {
        serviceRepository.deleteById(id);
    }
}
