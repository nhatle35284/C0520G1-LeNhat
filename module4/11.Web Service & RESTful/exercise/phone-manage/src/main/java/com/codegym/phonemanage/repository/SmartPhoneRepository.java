package com.codegym.phonemanage.repository;

import com.codegym.phonemanage.model.SmartPhone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmartPhoneRepository extends JpaRepository<SmartPhone,Integer> {
}
