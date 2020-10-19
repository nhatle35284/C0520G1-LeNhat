package nhat.coder.casestudyspring.service;

import nhat.coder.casestudyspring.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findAllTrue(Pageable pageable);

    Page<Customer> findAllName(String name,Pageable pageable);
    Page<Customer> findCustomerByCustomerTypeCustomerTypeName(String type,Pageable pageable);

    void save(Customer customer);

    Customer findById(String id);

    void update(Customer customer);

    void remove(String id);
    Page<Customer> findName(String search,Pageable pageable);
}
