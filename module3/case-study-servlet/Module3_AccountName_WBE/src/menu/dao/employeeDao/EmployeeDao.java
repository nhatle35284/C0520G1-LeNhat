package menu.dao.employeeDao;

import menu.dao.DBConnection;
import menu.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao implements IEmployeeDao {
    public static String SELECT_ALL_EMPLOYEE = "select * from employee";
    public static String DELETE_EMPLOYEE_SQL = "delete from employee where employee_id=?";
    public static String SEARCH_EMPLOYEE_SQL = "select *from employee where employee_name like ?";
    public static String FIND_EMPLOYEE_SQL = "select employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name from employee where employee_id=?";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_id,employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,user_name) vvalues (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name=?,employee_birthday=?,employee_id_card=?,employee_salary=?,employee_phone=?,employee_email=?,employee_address=?,position_id=?,education_degree_id=?,division_id=?,user_name=? where employee_id = ?";


    @Override
    public void insertEmployee(Employee employee) {
        try {
            PreparedStatement preparedStatement = null;
            preparedStatement = DBConnection.getConnection().prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setInt(1, employee.getEmployeeId());
            preparedStatement.setString(2, employee.getEmployeeName());
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
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public void updateEmployee(Employee employee) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);
        statement.setString(1, employee.getEmployeeName());
        statement.setString(2, employee.getEmployeeBirthday());
        statement.setString(3, employee.getEmployeeIdCard());
        statement.setDouble(4, employee.getEmployeeSalary());
        statement.setString(5, employee.getEmployeePhone());
        statement.setString(6, employee.getEmployeeEmail());
        statement.setString(7, employee.getEmployeeAddress());
        statement.setInt(8, employee.getPositionId());
        statement.setInt(9, employee.getEducationDegreeId());
        statement.setInt(10, employee.getDivisionId());
        statement.setString(11, employee.getUserName());
        statement.setInt(12, employee.getEmployeeId());
        statement.executeUpdate();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Employee employee = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_EMPLOYEE_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employeeName = rs.getString("employee_name");
                String employeeBirthday = rs.getString("employee_birthday");
                String employeeIdCard = rs.getString("employee_id_card");
                int employeeSalary = rs.getInt("employee_salary");
                String employeePhone = rs.getString("employee_phone");
                String employeeEmail = rs.getString("employee_email");
                String employeeAddress = rs.getString("employee_address");
                int positionId = rs.getInt("position_id");
                int educationDegreeId = rs.getInt("education_degree_id");
                int divisionId = rs.getInt("division_id");
                String userName = rs.getString("user_name");
                employee = new Employee(id, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, positionId, educationDegreeId, divisionId, userName);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void deleteEmployee(int id) throws SQLException {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchByName(String name) {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Employee> employeeList = new ArrayList<>();

        if (connection != null) {
            try {
            statement = connection.prepareStatement(SEARCH_EMPLOYEE_SQL);
            statement.setString(1, "%" + name + "%");
            resultSet = statement.executeQuery();
            Employee employee = null;
            while (resultSet.next()) {
                employee = new Employee();
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setEmployeeName(resultSet.getString("employee_name"));
                employee.setEmployeeBirthday(resultSet.getString("employee_birthday"));
                employee.setEmployeeIdCard(resultSet.getString("employee_id_card"));
                employee.setEmployeeSalary(resultSet.getDouble("employee_salary"));
                employee.setEmployeePhone(resultSet.getString("employee_phone"));
                employee.setEmployeeEmail(resultSet.getString("employee_email"));
                employee.setEmployeeAddress(resultSet.getString("employee_address"));
                employee.setPositionId(resultSet.getInt("education_degree_id"));
                employee.setEducationDegreeId(resultSet.getInt("employee_salary"));
                employee.setDivisionId(resultSet.getInt("division_id"));
                employee.setUserName(resultSet.getString("user_name"));
                employeeList.add(employee);
            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return employeeList;
    }
}
