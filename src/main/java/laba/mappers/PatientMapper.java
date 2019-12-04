package laba.mappers;

import laba.objects.Patient;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PatientMapper implements RowMapper<Patient> {
    @Override
    public Patient mapRow(ResultSet resultSet, int i) throws SQLException {
        Patient patient = new Patient();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        patient.setNumPassport(resultSet.getString("num_passport"));
        patient.setDoctorFIO(resultSet.getString("doctorFIO"));
        patient.setFIO(resultSet.getString("FIO"));
        try {
           patient.setDoB(dateFormat.parse(resultSet.getString("DoB")));
           patient.setRecordingDate(dateFormat.parse(resultSet.getString("recording_date")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        patient.setSex(resultSet.getBoolean("sex"));
        return patient;
    }
}
