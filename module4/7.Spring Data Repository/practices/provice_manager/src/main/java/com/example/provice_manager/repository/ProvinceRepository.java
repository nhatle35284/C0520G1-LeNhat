package com.example.provice_manager.repository;

import com.example.provice_manager.model.Province;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProvinceRepository extends PagingAndSortingRepository<Province, Long> {
}
