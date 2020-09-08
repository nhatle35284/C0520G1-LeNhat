package menu.bo.employeeBo;

import menu.dao.employeeDao.EmployeeDao;
import menu.dao.employeeDao.IEmployeeDao;
import menu.model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeBo implements IEmployeeBo {
    IEmployeeDao iEmployeeDao = new EmployeeDao();

    @Override
    public void insertEmployee(Employee employee) {
        iEmployeeDao.insertEmployee(employee);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return iEmployeeDao.selectAllEmployee();
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        iEmployeeDao.updateEmployee(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        return iEmployeeDao.getEmployeeById(id);
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        iEmployeeDao.deleteEmployee(id);
    }

    @Override
    public List<Employee> searchByName(String name) throws SQLException {
        return iEmployeeDao.searchByName(name);
    }
}
