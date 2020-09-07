package menu.dao;

import menu.model.Customer;
import menu.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    public static String SELECT_ALL_EMPLOYEE = "select * from employee";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name) " +
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
            preparedStatement.setInt(11, employee.getDivisionId());
            preparedStatement.setString(12, employee.getUserName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("employee_name");
                String employeeBirthday = rs.getString("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                double employeeSalary = rs.getDouble("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeEmail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("user_name");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId,educationDegreeId,divisionId,userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

}
