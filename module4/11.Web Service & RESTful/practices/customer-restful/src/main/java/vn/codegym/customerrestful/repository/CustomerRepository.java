package vn.codegym.customerrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.customerrestful.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
