package laba.dao;

import laba.mappers.DoctrosMapper;
import laba.objects.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class DoctorsDaoImp implements DoctorsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DoctorsDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Doctor> findAll() {
        String sql = "SELECT doctors.num_passport, doctors.FIO, profession.name_prof, doctors.salary, doctors.sex FROM doctors INNER JOIN profession ON doctors.prof_code = profession.code_p";
        return jdbcTemplate.query(sql, new DoctrosMapper());
    }

    @Override
    public Doctor getDoctorByPassport(String numPassport) {
        String sql = "SELECT doctors.num_passport, doctors.FIO, profession.name_prof, doctors.salary, doctors.sex FROM doctors INNER JOIN profession ON doctors.prof_code = profession.code_p WHERE num_passport = ?";
        Object[] objects = {numPassport};
        return jdbcTemplate.queryForObject(sql, objects, new DoctrosMapper());
    }

    @Override
    public void add(Doctor doctor) {
        String sql = "INSERT INTO doctors(num_passport, FIO, prof_code, salary, sex) VALUES (?, ?, (SELECT code_p FROM profession WHERE name_prof = ?), ?, ?)";
        boolean sex;
        if (doctor.getSex() == "муж") {
            sex = true;
        } else {
            sex = false;
        }
        Object[] objects = {doctor.getNumPassport(), doctor.getFIO(), doctor.getProfession(), doctor.getSalary(), doctor.getSex()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Doctor doctor) {
        String sql = "UPDATE doctors SET FIO = ?, prof_code = (SELECT code_p FROM profession WHERE name_prof = ?), salary = ?, sex = ? WHERE num_passport = ?";
        boolean sex;
        if (doctor.getSex() == "муж") {
            sex = true;
        } else {
            sex = false;
        }
        Object[] objects = {doctor.getFIO(), doctor.getProfession(), doctor.getSalary(), sex, doctor.getNumPassport()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(String numPassport) {
        String sql = "DELETE FROM doctors WHERE num_passport = ?";
        Object[] objects = {numPassport};
        jdbcTemplate.update(sql, objects);
    }
}
