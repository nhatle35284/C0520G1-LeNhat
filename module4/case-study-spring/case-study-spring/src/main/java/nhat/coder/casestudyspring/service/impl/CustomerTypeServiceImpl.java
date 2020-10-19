package nhat.coder.casestudyspring.service.impl;

import nhat.coder.casestudyspring.model.CustomerType;
import nhat.coder.casestudyspring.repository.CustomerTypeRepository;
import nhat.coder.casestudyspring.service.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
    @Autowired
    CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
