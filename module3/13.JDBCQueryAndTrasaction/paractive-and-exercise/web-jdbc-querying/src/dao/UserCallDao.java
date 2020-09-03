package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserCallDao implements IUserDao{
    BaseDAO baseDAO = new BaseDAO();
    private static final String SELECT_ALL_USERS ="{call get_all_user()}";
    private static final String UPDATE_USERS_SQL ="{call update_user(?,?,?,?)}";
    private static final String DELETE_USERS_SQL ="{call delete_user(?)}";
    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "(`name`, email, country) VALUES " +
            " (?, ?, ?);";
    private static final String INSERT_USERS_PERMISION_SQL = "INSERT INTO users_permision (permision_id,user_id) VALUES" +
            "(?,?)";
    private static final String SELECT_USER_BY_COUNTRY = "{call search_by_country(?)}";
    @Override
    public void insertUser(User user, int id) throws SQLException {
        Connection connection = this.baseDAO.getConnection();
        try {
            connection.setAutoCommit(false);
            if (id>0 && id<5) {
                PreparedStatement preparedStatement =connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getEmail());
                preparedStatement.setString(3, user.getCountry());
                preparedStatement.executeUpdate();
                ResultSet rs = preparedStatement.getGeneratedKeys();
                int userId = 0;
                if (rs.next()){
                    userId = rs.getInt(1);
                }


                PreparedStatement prstInsertUP = connection.prepareStatement(INSERT_USERS_PERMISION_SQL);
                prstInsertUP.setInt(1, id);
                prstInsertUP.setInt(2, userId);
                prstInsertUP.executeUpdate();
                connection.commit();
            }else {
                connection.rollback();
            }

            connection.setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(SELECT_ALL_USERS);
            ResultSet rs =callableStatement.executeQuery();
            User user = null;
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        boolean rowDelete;
        CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(DELETE_USERS_SQL);
        callableStatement.setInt(1,id);
        rowDelete = callableStatement.executeUpdate() > 0;
        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdate;
        CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(UPDATE_USERS_SQL);
        callableStatement.setString(1,user.getName());
        callableStatement.setString(2,user.getEmail());
        callableStatement.setString(3,user.getCountry());
        callableStatement.setInt(4,user.getId());
        rowUpdate = callableStatement.executeUpdate() > 0;
        return rowUpdate;
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        List<User> userList = new ArrayList<>();
        try {
            CallableStatement callableStatement = this.baseDAO.getConnection().prepareCall(SELECT_USER_BY_COUNTRY);
            callableStatement.setString(1,country);
            ResultSet rs = callableStatement.executeQuery();
            User user;
            while (rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setCountry(rs.getString("country"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}