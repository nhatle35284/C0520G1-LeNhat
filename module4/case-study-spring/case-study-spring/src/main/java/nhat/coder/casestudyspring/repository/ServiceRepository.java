package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service,String> {
}
