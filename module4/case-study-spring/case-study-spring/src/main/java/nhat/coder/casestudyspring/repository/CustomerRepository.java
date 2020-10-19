package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.Contract;
import nhat.coder.casestudyspring.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Page<Customer> findByCustomerNameContaining(String search,Pageable pageable);
    Page<Customer> findAllByStatusTrue(Pageable pageable);
    Page<Customer> findAllByCustomerNameContaining(String name,Pageable pageable);
    Page<Customer> findCustomerByCustomerTypeCustomerTypeName(String type,Pageable pageable);
}
