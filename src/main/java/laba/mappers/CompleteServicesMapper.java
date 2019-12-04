package laba.mappers;

import laba.objects.CompleteServices;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CompleteServicesMapper implements RowMapper<CompleteServices> {
    @Override
    public CompleteServices mapRow(ResultSet resultSet, int i) throws SQLException {
        CompleteServices completeServices = new CompleteServices();
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("HH:mm");
        completeServices.setId(resultSet.getInt("id"));
        completeServices.setServiceName(resultSet.getString("service_name"));
        completeServices.setNameDoctor(resultSet.getString("doctor_FIO"));
        completeServices.setNamePatient(resultSet.getString("patient_FIO"));
        try {
            completeServices.setDateComplete(dateFormat1.parse(resultSet.getString("date_complete")));
            completeServices.setTimeBegin(dateFormat2.parse(resultSet.getString("time_begin")));
            completeServices.setTimeEnd(dateFormat2.parse(resultSet.getString("time_end")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        completeServices.setCost(resultSet.getInt("cost"));
        return completeServices;
    }
}
