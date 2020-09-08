package menu.bo.employeeBo;

import menu.model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeBo {
    public void insertEmployee(Employee employee);
    List<Employee> selectAllEmployee();
    public void updateEmployee(Employee employee) throws SQLException;
    Employee getEmployeeById(int id);
    void deleteEmployee(int id) throws SQLException;
    public List<Employee> searchByName(String name) throws SQLException;

}
