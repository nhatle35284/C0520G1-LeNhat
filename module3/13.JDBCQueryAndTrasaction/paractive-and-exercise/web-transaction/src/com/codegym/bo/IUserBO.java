package com.codegym.bo;

import com.codegym.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserBO {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    void insertTransaction(User user,int id_contract,int id_user,String name_contract) throws SQLException;
}
