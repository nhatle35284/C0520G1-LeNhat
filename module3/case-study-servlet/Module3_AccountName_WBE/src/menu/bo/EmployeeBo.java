package menu.bo;

import menu.dao.EmployeeDao;
import menu.dao.IEmployeeDao;
import menu.model.Employee;

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
}
