package nhat.coder.casestudyspring.repository;

import nhat.coder.casestudyspring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
