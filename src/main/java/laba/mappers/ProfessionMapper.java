package laba.mappers;

import laba.objects.Profession;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessionMapper implements RowMapper<Profession> {
    @Override
    public Profession mapRow(ResultSet resultSet, int i) throws SQLException {
        Profession profession = new Profession();
        profession.setCode(resultSet.getString("code_p"));
        profession.setName(resultSet.getString("name_prof"));
        return profession;
    }
}
