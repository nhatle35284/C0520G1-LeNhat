package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerTypeRepository extends JpaRepository<CustomerType,String> {
}
