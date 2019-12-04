package laba.dao;

import laba.mappers.ProfessionMapper;
import laba.objects.Profession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProfessionDaoImp implements ProfessionDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ProfessionDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Profession> findAll() {
        String sql = "SELECT * FROM profession";
        return jdbcTemplate.query(sql, new ProfessionMapper());
    }

    @Override
    public Profession getByCode(String code) {
        String sql = "SELECT * FROM profession WHERE code_p = ?";
        Object[] objects = {code};
        return jdbcTemplate.queryForObject(sql, objects, new ProfessionMapper());
    }

    @Override
    public void add(Profession profession) {
        String sql = "INSERT INTO profession(code_p, name_prof) VALUES (?, ?)";
        Object[] objects = {profession.getCode(), profession.getName()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(String code) {
        String sql = "DELETE FROM profession WHERE code_p = ?";
        Object[] objects = {code};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Profession profession) {
        String sql = "UPDATE profession SET name_prof = ? WHERE code_p = ?";
        Object[] objects = {profession.getName(), profession.getCode()};
        jdbcTemplate.update(sql, objects);
    }
}
