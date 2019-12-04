package laba.mappers;

import laba.objects.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceMapper implements RowMapper<Service> {
    @Override
    public Service mapRow(ResultSet resultSet, int i) throws SQLException {
        Service service = new Service();
        service.setCode(resultSet.getString("code_s"));
        service.setTypeName(resultSet.getString("type_name"));
        service.setName(resultSet.getString("name_service"));
        service.setCost(resultSet.getInt("cost"));
        return service;
    }
}
