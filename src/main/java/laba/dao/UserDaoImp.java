package laba.dao;

import laba.mappers.UserMapper;
import laba.objects.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImp implements UserDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<User> findAllUsers() {
        String sql = "SELECT * FROM userList";
        return jdbcTemplate.query(sql, new UserMapper());
    }

    @Override
    public User getByName(String userName) {
        String sql = "SELECT * FROM userList WHERE user_name = ?";
        Object[] objects = {userName};
        try {
            return jdbcTemplate.queryForObject(sql, objects, new UserMapper());
        }
        catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void addNewUser(User user) {
        String sql = "INSERT INTO userList(user_name, user_password, user_admin) values(?, ?, ?);";
        Object[] objects = {user.getName(), user.getPassword(), user.isAdmin()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void deleteUser(String userName) {
        String sql = "DELETE FROM userList WHERE user_name = ?";
        Object[] objects = {userName};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void updateUser(User user) {
        String sql = "UPDATE userList SET user_password = ?, user_admin = ? WHERE user_name = ?";
        Object[] objects = {user.getPassword(), user.isAdmin(), user.getName()};
        jdbcTemplate.update(sql, objects);
    }

}
