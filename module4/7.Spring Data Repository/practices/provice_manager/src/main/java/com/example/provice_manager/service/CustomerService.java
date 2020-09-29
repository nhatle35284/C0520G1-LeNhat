package com.example.provice_manager.service;

import com.example.provice_manager.model.Customer;
import com.example.provice_manager.model.Province;

import java.util.List;

public interface CustomerService {
    public Iterable<Customer> findAll();
    public Customer findById(Long id);
    public void save(Customer customer);
    public void remove(Long id);
    List<Customer> findAllByProvince(Province province);
}
