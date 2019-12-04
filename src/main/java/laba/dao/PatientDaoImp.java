package laba.dao;

import laba.mappers.PatientMapper;
import laba.objects.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class PatientDaoImp implements PatientDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PatientDaoImp(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Patient> findAll() {
        String sql = "SELECT p.num_passport, p.FIO, p.DoB, p.recording_date, p.sex, d.FIO AS doctorFIO FROM patients p INNER JOIN doctors d ON p.num_passport_doctor = d.num_passport";
        return jdbcTemplate.query(sql, new PatientMapper());
    }

    @Override
    public Patient getPatientByNumPassport(String numPassport) {
        String sql = "SELECT p.num_passport, p.FIO, p.DoB, p.recording_date, p.sex, d.FIO AS doctorFIO FROM patients p INNER JOIN doctors d ON p.num_passport_doctor = d.num_passport where p.num_passport = ?";
        Object[] objects = {numPassport};
        return jdbcTemplate.queryForObject(sql, objects, new PatientMapper());
    }

    @Override
    public Patient getPatientByName(String patientName) {
        String sql = "SELECT p.num_passport, p.FIO, p.DoB, p.recording_date, p.sex, d.FIO AS doctorFIO FROM patients p INNER JOIN doctors d ON p.num_passport_doctor = d.num_passport WHERE p.FIO = ?";
        Object[] objects = {patientName};
        return jdbcTemplate.queryForObject(sql, objects, new PatientMapper());
    }

    @Override
    public List<Patient> getPatientsByDoctorName(String doctorName) {
        String sql = "SELECT p.num_passport, p.FIO, p.DoB, p.recording_date, p.sex, d.FIO AS doctorFIO FROM patients p INNER JOIN doctors d ON p.num_passport_doctor = d.num_passport WHERE d.FIO = ?";
        Object[] objects = {doctorName};
        return jdbcTemplate.query(sql, objects, new PatientMapper());
    }

    @Override
    public void add(Patient patient) {
        String sql = "INSERT INTO patients(num_passport, num_passport_doctor, FIO, DoB, recording_date, sex) VALUES (?, (SELECT num_passport FROM doctors WHERE FIO = ?), ?, ?, ?, ?)";
        Object[] objects = {patient.getNumPassport(), patient.getDoctorFIO(), patient.getFIO(), patient.getDoB(), patient.getRecordingDate(), patient.isSex()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(Patient patient) {
        String sql = "UPDATE patients SET num_passport_doctor = (SELECT num_passport FROM doctors WHERE FIO = ?), FIO = ?, DoB = ?, recording_date = ?, sex = ? WHERE num_passport = ?";
        Object[] objects = {patient.getFIO(), patient.getDoctorFIO(), patient.getDoB(), patient.getRecordingDate(), patient.isSex(), patient.getNumPassport()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void delete(String numPassport) {
        String sql = "DELETE FROM patients WHERE num_passport = ?";
        Object[] objects = {numPassport};
        jdbcTemplate.update(sql, objects);
    }
}
