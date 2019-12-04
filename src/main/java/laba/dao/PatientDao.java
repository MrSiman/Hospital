package laba.dao;

import laba.objects.Patient;

import java.util.List;

public interface PatientDao {
    public List<Patient> findAll();
    public Patient getPatientByNumPassport(String numPassport);
    public Patient getPatientByName(String patientName);
    public List<Patient> getPatientsByDoctorName(String doctorName);
    public void add(Patient patient);
    public void update(Patient patient);
    public void delete(String numPassport);
}
