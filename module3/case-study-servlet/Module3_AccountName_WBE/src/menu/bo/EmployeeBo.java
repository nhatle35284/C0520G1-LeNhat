package menu.bo;

import menu.dao.EmployeeDao;
import menu.dao.IEmployeeDao;
import menu.model.Employee;

public class EmployeeBo implements IEmployeeBo {
    IEmployeeDao iEmployeeDao = new EmployeeDao();

    @Override
    public void insertEmployee(Employee employee) {
        iEmployeeDao.insertEmployee(employee);
    }
}
