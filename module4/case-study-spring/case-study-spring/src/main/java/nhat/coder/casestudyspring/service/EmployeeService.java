package nhat.coder.casestudyspring.service;

import nhat.coder.casestudyspring.model.Customer;
import nhat.coder.casestudyspring.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(String id);

    void update(Employee employee);

    void remove(String id);
}
