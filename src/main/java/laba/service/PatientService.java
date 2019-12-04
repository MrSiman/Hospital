package laba.service;

import laba.exceptions.IncorrectNumPassportException;
import laba.objects.Patient;
import laba.objects.PatientDTS;

import java.text.ParseException;
import java.util.List;

public interface PatientService {
    public PatientDTS patientToPatientDTS(Patient patient);
    public Patient patientDTSToPatient(PatientDTS patientDTS) throws ParseException;
    public List<PatientDTS> findAll();
    public PatientDTS getPatientByNumPassport(String numPassport);
    public List<PatientDTS> getPatientsByDoctorName(String doctorName);
    public void add(PatientDTS patientDTS) throws ParseException, IncorrectNumPassportException;
    public void update(PatientDTS patientDTS) throws ParseException;
    public void delete(String numPassport);
    public void deleteByPatientName(String patientName);
}
