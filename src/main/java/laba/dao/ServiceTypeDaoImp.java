package laba.dao;

import laba.mappers.ServiceTypeMapper;
import laba.objects.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServiceTypeDaoImp implements ServiceTypeDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceTypeDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ServiceType> findAll() {
        String sql = "SELECT * FROM service_type";
        return jdbcTemplate.query(sql, new ServiceTypeMapper());
    }

    @Override
    public ServiceType getByTypeServiceCode(String typeServiceCode) {
        String sql = "SELECT * FROM service_type WHERE code_t = ?";
        Object[] objects = {typeServiceCode};
        return jdbcTemplate.queryForObject(sql, objects, new ServiceTypeMapper());
    }

    @Override
    public void add(ServiceType serviceType) {
        String sql = "INSERT INTO service_type(code_t, type_name) VALUES(?, ?)";
        Object[] objects = {serviceType.getTypeServiceCode(), serviceType.getTypeName()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(String typeServiceCode) {
        String sql = "DELETE FROM service_type WHERE code_t = ?";
        Object[] objects = {typeServiceCode};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(ServiceType serviceType) {
        String sql = "UPDATE service_type SET type_name = ? WHERE code_t = ?";
        Object[] objects = {serviceType.getTypeName(), serviceType.getTypeServiceCode()};
        jdbcTemplate.update(sql, objects);
    }
}
