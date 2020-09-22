package com.codegym.repository;

import com.codegym.model.Login;
import com.codegym.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private static List<User> users;
    static {
        users = new ArrayList<>();
        User user = new User("john","123456","John","john@codegym.vn",10);
        User user1 = new User("bill","123456","Bill","bill@codegym.vn",15);
        User user2 = new User("mike","123456","Mike","mike@codegym.vn",20);
        users.add(user);
        users.add(user1);
        users.add(user2);
//        User u1 = new User();
//        u1.setAge(10);
//        u1.setName("John");
//        u1.setAccount("john");
//        u1.setEmail("john@codegym.vn");
//        u1.setPassword("123456");
//        users.add(u1);

//        User u2 = new User();
//        u2.setAge(15);
//        u2.setName("Bill");
//        u2.setAccount("bill");
//        u2.setEmail("bill@codegym.vn");
//        u2.setPassword("123456");
//        users.add(u2);
//
//        User u3 = new User();
//        u3.setAge(16);
//        u3.setName("Mike");
//        u3.setAccount("mike");
//        u2.setEmail("mike@codegym.vn");
//        u3.setPassword("123456");
//        users.add(u3);
    }

    public static User checkLogin(Login login){
        for (User u: users) {
            if(u.getAccount().equals(login.getAccount())
                    && u.getPassword().equals(login.getPassword())){
                return u;
            }
        }
        return null;
    }
}
