package laba.service;

import laba.objects.CompleteServices;
import laba.objects.CompleteServicesDTS;

import java.text.ParseException;
import java.util.List;

public interface CompleteServService {
    public CompleteServicesDTS CSToCSDTS(CompleteServices completeServices);
    public CompleteServices CSDTSToCS(CompleteServicesDTS completeServicesDTS) throws ParseException;
    public List<CompleteServicesDTS> findAll();
    public List<CompleteServicesDTS> findByPatientName(String patientName);
    public List<CompleteServicesDTS> findByDoctorName(String doctorName);
    public void add(CompleteServicesDTS completeServicesDTS) throws ParseException;
    public void update(CompleteServicesDTS completeServicesDTS) throws ParseException;
    public void delete(int id);
}
