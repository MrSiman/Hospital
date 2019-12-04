package laba.mappers;

import laba.objects.Doctor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctrosMapper implements RowMapper<Doctor> {
    @Override
    public Doctor mapRow(ResultSet resultSet, int i) throws SQLException {
        Doctor doctor = new Doctor();
        doctor.setNumPassport(resultSet.getString("num_passport"));
        doctor.setFIO(resultSet.getString("FIO"));
        doctor.setProfession(resultSet.getString("name_prof"));
        doctor.setSalary(resultSet.getInt("salary"));
        boolean b_sex = resultSet.getBoolean("sex");
        if (b_sex == true) {
            doctor.setSex("муж");
        } else {
            doctor.setSex("жен");
        }
        return doctor;
    }
}
