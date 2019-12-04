package laba.dao;

import laba.objects.CompleteServices;

import java.util.List;

public interface CompleteServicesDao {
    public List<CompleteServices> findAll();
    public List<CompleteServices> findByPatientName(String patientName);
    public List<CompleteServices> findByDoctorName(String doctorName);
    public void add(CompleteServices completeServices);
    public void update(CompleteServices completeServices);
    public void delete(int id);
}
