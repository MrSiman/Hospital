package laba.dao;

import laba.objects.User;

import java.util.List;

public interface UserDao {
    public List<User> findAllUsers();
    public User getByName(String userName);
    public void addNewUser(User user);
    public void deleteUser(String userName);
    public void updateUser(User user);
}
