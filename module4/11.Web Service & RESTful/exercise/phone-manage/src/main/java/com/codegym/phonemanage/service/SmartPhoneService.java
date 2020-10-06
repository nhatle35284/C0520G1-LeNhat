package com.codegym.phonemanage.service;

import com.codegym.phonemanage.model.SmartPhone;

public interface SmartPhoneService  {
    Iterable<SmartPhone> findAll();
    SmartPhone findById(Integer id);
    SmartPhone save(SmartPhone phone);
    SmartPhone remove(Integer id);
}
