package vn.codegym.customlog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import vn.codegym.customlog.model.Province;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
}
