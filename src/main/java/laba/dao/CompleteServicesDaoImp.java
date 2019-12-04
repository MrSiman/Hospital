package laba.dao;

import laba.mappers.CompleteServicesMapper;
import laba.objects.CompleteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CompleteServicesDaoImp implements CompleteServicesDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CompleteServicesDaoImp (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CompleteServices> findAll() {
        String sql = "SELECT * FROM complete_services";
        return jdbcTemplate.query(sql, new CompleteServicesMapper());
    }

    @Override
    public List<CompleteServices> findByPatientName(String patientName) {
        String sql = "SELECT * FROM complete_services WHERE patient_FIO = ?";
        Object[] objects = {patientName};
        return jdbcTemplate.query(sql, objects, new CompleteServicesMapper());
    }

    @Override
    public List<CompleteServices> findByDoctorName(String doctorName) {
        String sql = "SELECT * FROM complete_services WHERE doctor_FIO = ?";
        Object[] objects = {doctorName};
        return jdbcTemplate.query(sql, objects, new CompleteServicesMapper());
    }

    @Override
    public void add(CompleteServices completeServices) {
        String sql = "INSERT INTO complete_services(service_name, doctor_FIO, patient_FIO, date_complete, time_begin, time_end, cost) VALUES(?, ?, ?, ?, ?, ?, (SELECT cost FROM service_list WHERE name_service = ?))";
        Object[] objects = {completeServices.getServiceName(), completeServices.getNameDoctor(), completeServices.getNamePatient(), completeServices.getDateComplete(), completeServices.getTimeBegin(), completeServices.getTimeEnd(), completeServices.getServiceName()};
        jdbcTemplate.update(sql, objects);
    }

    @Override
    public void update(CompleteServices completeServices) {

    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM complete_services WHERE id = ?";
        Object[] objects = {id};
        jdbcTemplate.update(sql, objects);
    }
}
