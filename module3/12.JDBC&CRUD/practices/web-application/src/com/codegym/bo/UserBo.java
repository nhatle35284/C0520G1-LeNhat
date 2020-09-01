package com.codegym.bo;

import com.codegym.dao.IUserDAO;
import com.codegym.dao.UserDAO;
import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserBo implements IUserBo {
    private IUserDAO iUserDAO = new UserDAO();
    @Override
    public void insertUser(User user) throws SQLException {
        iUserDAO.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserDAO.selectAllUsers();
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
    public List<User> searchByCountry(String country) {
        return iUserDAO.searchByCountry(country);
    }

    @Override
    public List<User> sortAllUsers() {
        return iUserDAO.sortAllUsers();
    }

    @Override
    public User getUserById(int id) {
        return iUserDAO.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        iUserDAO.insertUserStore(user);
    }
}
