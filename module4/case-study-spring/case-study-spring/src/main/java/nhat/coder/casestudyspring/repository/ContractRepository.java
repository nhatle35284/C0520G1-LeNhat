package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository extends JpaRepository<Contract,String> {
}
