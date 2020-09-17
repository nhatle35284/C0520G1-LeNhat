package menu.dao;

import menu.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao {
    public static String INSERT_PRODUCT_SQL = "insert into product (id,name,price,quantity,color,`description`,category)values (?,?,?,?,?,?,?) ";
    public static final String SELECT_ALL_PRODUCT = "select * from  product";
    public static final String DELETE_PRODUCT_SQL = "delete from product where id = ?";
    public static final String FIND_CUSTOMER_SQL = "select name,price,quantity,color,`description`,category from product where id = ?";
    public static final String UPDATE_PRODUCT_SQL = "update product set name=?,price=?,quantity,color=?,`description`=?,category=? where id = ?";
    @Override
    public List<Product> selectAllProduct() {
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                products.add(new Product(id, productName, price, quantity, color, description, category));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public void insertProduct(Product product) {
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);
            preparedStatement.setInt(1, product.getId());
            preparedStatement.setString(2, product.getProductName());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setString(5, product.getColor());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setString(7, product.getCategory());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product getProductById(int id) {
        Product product = null;
        Connection connection = DBConnection.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(FIND_CUSTOMER_SQL);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                id = rs.getInt("id");
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String category = rs.getString("category");
                product = new Product(id, productName, price, quantity, color, description, category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    @Override
    public void deleteProduct(int id) throws SQLException {
        try {
            Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void updateProduct(Product product) throws SQLException {
        Connection connection = DBConnection.getConnection();
        PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);

        statement.setString(1, product.getProductName());
        statement.setDouble(2, product.getPrice());
        statement.setInt(3, product.getQuantity());
        statement.setString(4, product.getColor());
        statement.setString(5, product.getDescription());
        statement.setString(6, product.getCategory());
        statement.setInt(7, product.getId());
        statement.executeUpdate();
    }

//    @Override
//    public List<Product> searchByName(String name) {
//        Connection connection = DBConnection.getConnection();
//        PreparedStatement statement = null;
//        ResultSet resultSet = null;
//        List<Customer> customerList = new ArrayList<>();
//
//        if (connection != null) {
//            try {
//                statement = connection.prepareStatement(SEARCH_CUSTOMER_SQL);
//                statement.setString(1, "%" + name + "%");
//                resultSet = statement.executeQuery();
//                Customer customer = null;
//                while (resultSet.next()) {
//                    customer = new Customer();
//                    customer.setCustomerId(resultSet.getString("customer_id"));
//                    customer.setCustomerTypeId(resultSet.getInt("customer_type_id"));
//                    customer.setCustomerName(resultSet.getString("customer_name"));
//                    customer.setCustomerBirthday(resultSet.getString("customer_birthday"));
//                    customer.setCustomerGender(resultSet.getInt("customer_gender"));
//                    customer.setCustomerIdCard(resultSet.getString("customer_id_card"));
//                    customer.setCustomerPhone(resultSet.getString("customer_phone"));
//                    customer.setCustomerEmail(resultSet.getString("customer_email"));
//                    customer.setCustomerAddress(resultSet.getString("customer_address"));
//                    customerList.add(customer);
//                }
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            } finally {
//                try {
//                    resultSet.close();
//                    statement.close();
//                } catch (SQLException throwables) {
//                    throwables.printStackTrace();
//                }
//            }
//        }
//        return customerList;
//    }

}
