package menu.dao.customerDao;

import menu.dao.DBConnection;
import menu.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao {
    public static String INSERT_CUSTOMER_SQL = "insert into customer (customer_id,customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)values (?,?,?,?,?,?,?,?,?) ";
    public static String SELECT_ALL_CUSTOMER = "select * from customer";
    public static String DELETE_CUSTOMER_SQL = "delete from customer where customer_id=?";
    public static String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id=?,customer_name=?,customer_birthday=?,customer_gender=?,customer_id_card=?,customer_phone=?,customer_email=?,customer_address=? where customer_id=?";
    public static String FIND_CUSTOMER_SQL = "select customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address from customer where customer_id=?";

    @Override
    public void insertCustomer(Customer customer) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setInt(1, customer.getCustomerId());
            preparedStatement.setInt(2, customer.getCustomerTypeId());
            preparedStatement.setString(3, customer.getCustomerName());
            preparedStatement.setString(4, customer.getCustomerBirthday());
            preparedStatement.setInt(5, customer.getCustomerGender());
            preparedStatement.setInt(6, customer.getCustomerIdCard());
            preparedStatement.setString(7, customer.getCustomerPhone());
            preparedStatement.setString(8, customer.getCustomerEmail());
            preparedStatement.setString(9, customer.getCustomerAddress());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int customerId = rs.getInt("customer_id");
                int customerTypeId = rs.getInt("customer_type_id");
                String customerName = rs.getString("customer_name");
                String customerBirthday = rs.getString("customer_birthday");
                int customerGender = rs.getInt("customer_gender");
                int customerIdCard = rs.getInt("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");
                customers.add(new Customer(customerId, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void updateCustomer(Customer customer) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);

        statement.setInt(1, customer.getCustomerTypeId());
        statement.setString(2, customer.getCustomerName());
        statement.setString(3, customer.getCustomerBirthday());
        statement.setInt(4, customer.getCustomerGender());
        statement.setInt(5, customer.getCustomerIdCard());
        statement.setString(6, customer.getCustomerPhone());
        statement.setString(7, customer.getCustomerEmail());
        statement.setString(8, customer.getCustomerAddress());
        statement.setInt(9, customer.getCustomerId());
        statement.executeUpdate();
    }

    @Override
    public Customer getCustomerById(int id) {
        Customer customer = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int customerTypeId = rs.getInt("customer_type_id");
                String customerName = rs.getString("customer_name");
                String customerBirthday = rs.getString("customer_birthday");
                int customerGender = rs.getInt("customer_gender");
                int customerIdCard = rs.getInt("customer_id_card");
                String customerPhone = rs.getString("customer_phone");
                String customerEmail = rs.getString("customer_email");
                String customerAddress = rs.getString("customer_address");
                customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard, customerPhone, customerEmail, customerAddress);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public void deleteCustomer(int id) throws SQLException {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
