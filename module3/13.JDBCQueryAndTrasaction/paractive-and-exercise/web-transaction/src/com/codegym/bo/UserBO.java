package com.codegym.bo;

import com.codegym.dao.IUserDAO;
import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBO implements IUserBO{
    private IUserDAO userDAO = new UserDAO();
    @Override
    public void insertUser(User user) throws SQLException {
        userDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return userDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return userDAO.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return false;
    }

    @Override
    public void insertTransaction(User user, int id_contract, int id_user, String name_contract) throws SQLException {
        userDAO.insertTransaction(user,id_contract,id_user,name_contract);
    }
}
