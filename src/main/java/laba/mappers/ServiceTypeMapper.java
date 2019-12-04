package laba.mappers;

import laba.objects.ServiceType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ServiceTypeMapper implements RowMapper<ServiceType> {
    @Override
    public ServiceType mapRow(ResultSet resultSet, int i) throws SQLException {
        ServiceType serviceType = new ServiceType();
        serviceType.setTypeServiceCode(resultSet.getString("code_t"));
        serviceType.setTypeName(resultSet.getString("type_name"));
        return serviceType;
    }
}
