package menu.bo;

import menu.model.Employee;

import java.util.List;

public interface IEmployeeBo {
    public void insertEmployee(Employee employee);
    List<Employee> selectAllEmployee();
}
