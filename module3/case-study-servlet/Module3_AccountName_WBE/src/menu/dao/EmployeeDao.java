package menu.dao;

import menu.model.Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDao implements IEmployeeDao {
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,\n" +
            "employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name) " +
            " values (?,?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1, employee.getEmployee_Id());
            preparedStatement.setString(2, employee.getEmployee_Name());
            preparedStatement.setString(3, employee.getEmployeeBirthday());
            preparedStatement.setString(4, employee.getEmployeeIdCard());
            preparedStatement.setDouble(5, employee.getEmployeeSalary());
            preparedStatement.setString(6, employee.getEmployeePhone());
            preparedStatement.setString(7, employee.getEmployeeEmail());
            preparedStatement.setString(8, employee.getEmployeeAddress());
            preparedStatement.setInt(9, employee.getPositionId());
            preparedStatement.setInt(10, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(10, employee.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
