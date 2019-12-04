package laba.service;

import laba.dao.UserDao;
import laba.objects.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImp implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    @Override
    public User getByName(String userName) {
        return userDao.getByName(userName);
    }

    @Override
    public void addNewUser(User user) {
        userDao.addNewUser(user);
    }

    @Override
    public void deleteUser(String userName) {
        userDao.deleteUser(userName);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
