package laba.dao;

import laba.mappers.ServiceMapper;
import laba.objects.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ServiceDaoImp implements ServiceDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Service> findAll() {
        String sql = "SELECT sl.code_s, st.type_name, sl.name_service, sl.cost FROM service_list sl INNER JOIN service_type st ON sl.type_code = st.code_t";
        return jdbcTemplate.query(sql, new ServiceMapper());
    }

    @Override
    public Service getByCode(String code) {
        String sql = "SELECT sl.code_s, st.type_name, sl.name_service, sl.cost FROM service_list sl INNER JOIN service_type st ON sl.type_code = st.code_t WHERE code_s = ?";
        Object[] objects = {code};
        return jdbcTemplate.queryForObject(sql, objects, new ServiceMapper());
    }

    @Override
    public void add(Service service) {
        String sql = "INSERT INTO service_list(code_s, type_code, name_service, cost) VALUES (?, (SELECT code_t FROM service_type WHERE type_name = ?), ?, ?)";
        Object[] objects = {service.getCode(), service.getTypeName(), service.getName(), service.getCost()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Service service) {
        String sql = "UPDATE service_list SET type_code = (SELECT code_t FROM service_type WHERE type_name = ?), name_service = ?, cost = ? WHERE code_s = ?";
        Object[] objects = {service.getTypeName(), service.getName(), service.getCost(), service.getCode()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(String code) {
        String sql = "DELETE FROM service_list WHERE code_s = ?";
        Object[] objects = {code};
        jdbcTemplate.update(sql, objects);
    }
}