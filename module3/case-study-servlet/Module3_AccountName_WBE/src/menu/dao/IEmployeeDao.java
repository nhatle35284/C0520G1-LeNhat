package menu.dao;

import menu.model.Customer;
import menu.model.Employee;

import java.util.List;

public interface IEmployeeDao {
    public void insertEmployee(Employee employee);
    public List<Employee> selectAllEmployee();
}
