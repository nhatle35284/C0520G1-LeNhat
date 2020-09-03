package bo;

import dao.UserCallDao;
import dao.UserDao;
import model.User;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class UserBO implements IUserBO{
    private UserDao userDao = new UserDao();
    private UserCallDao userCallDao = new UserCallDao();
    @Override
    public void insertUser(User user, int id) throws SQLException {
        this.userCallDao.insertUser(user,id);
    }

    @Override
    public User selectUser(int id) {
        return this.userDao.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.userCallDao.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.userCallDao.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.userCallDao.updateUser(user);
    }

    @Override
    public List<User> selectUserByCountry(String country) {
        return this.userCallDao.selectUserByCountry(country);
    }

    @Override
    public List<User> sortAllUsers() {
        List<User> sortList = this.userDao.selectAllUsers();
        Collections.sort(sortList,new CompareUser());
        return sortList;
    }
}
