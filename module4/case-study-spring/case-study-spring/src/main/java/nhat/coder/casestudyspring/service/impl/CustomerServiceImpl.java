package nhat.coder.casestudyspring.service.impl;

import nhat.coder.casestudyspring.model.Customer;
import nhat.coder.casestudyspring.repository.CustomerRepository;
import nhat.coder.casestudyspring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> findAllTrue(Pageable pageable) {
        return customerRepository.findAllByStatusTrue(pageable);
    }

    @Override
    public Page<Customer> findAllName(String name,Pageable pageable) {
        return customerRepository.findAllByCustomerNameContaining(name,pageable);
    }

    @Override
    public Page<Customer> findCustomerByCustomerTypeCustomerTypeName(String type,Pageable pageable) {
        return customerRepository.findCustomerByCustomerTypeCustomerTypeName(type,pageable);
    }


    @Override
    public void save(Customer customer) {
        customer.setStatus(true);
        customerRepository.save(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(String id) {
        Customer customer= customerRepository.findById(id).orElse(null);
        customer.setStatus(false);
        customerRepository.save(customer);
    }

    @Override
    public Page<Customer> findName(String search, Pageable pageable) {
        return customerRepository.findByCustomerNameContaining(search,pageable);
    }
}
