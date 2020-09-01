package com.codegym.dao;

import com.codegym.model.User;

import java.util.List;

public interface UserDao {
    void UserDAO();

    List<User> searchByName();
}
