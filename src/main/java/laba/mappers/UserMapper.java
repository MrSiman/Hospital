package laba.mappers;

import laba.objects.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setName(resultSet.getString("user_name"));
        user.setPassword(resultSet.getString("user_password"));
        user.setAdmin(resultSet.getBoolean("user_admin"));
        return user;
    }
}
