package com.example.provice_manager.repository;

import com.example.provice_manager.model.Customer;
import com.example.provice_manager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    List<Customer> findAllByProvince(Province province);
}
