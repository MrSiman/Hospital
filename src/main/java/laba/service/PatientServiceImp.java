package laba.service;

import laba.controllers.HospitalController;
import laba.dao.PatientDao;
import laba.exceptions.IncorrectNumPassportException;
import laba.objects.Patient;
import laba.objects.PatientDTS;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientServiceImp implements PatientService {

    @Autowired
    PatientDao patientDao;

    @Override
    public PatientDTS patientToPatientDTS(Patient patient) {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String doB = dateFormat.format(patient.getDoB());
        String recordingDate = dateFormat.format(patient.getRecordingDate());
        String sex;
        if (patient.isSex() == true) {
            sex = "муж";
        }
        else {
            sex = "жен";
        }
        PatientDTS patientDTS = new PatientDTS(patient.getNumPassport(), patient.getFIO(), patient.getDoctorFIO(), doB, recordingDate, sex);
        return patientDTS;
    }

    @Override
    public Patient patientDTSToPatient(PatientDTS patientDTS) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date doB= dateFormat.parse(patientDTS.getDoB());
        Date recordingDate = dateFormat.parse(patientDTS.getRecordingDate());
        boolean sex;
        if (patientDTS.getSex() == "муж") {
            sex = true;
        } else {
            sex = false;
        }
        Patient patient = new Patient(patientDTS.getNumPassport(), StringManip.setCorrectCaseForFIO(patientDTS.getFIO()), patientDTS.getDoctorFIO(), doB, recordingDate, sex);
        return patient;
    }

    @Override
    public List<PatientDTS> findAll() {
        List<Patient> patients = patientDao.findAll();
        List<PatientDTS> patientDTSList = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTSList.add(patientToPatientDTS(patient));
        }
        return patientDTSList;
    }

    @Override
    public PatientDTS getPatientByNumPassport(String numPassport) {
        PatientDTS patientDTS = patientToPatientDTS(patientDao.getPatientByNumPassport(numPassport));
        return patientDTS;
    }

    @Override
    public List<PatientDTS> getPatientsByDoctorName(String doctorName) {
        List<Patient> patients = patientDao.getPatientsByDoctorName(doctorName);
        List<PatientDTS> patientDTSList = new ArrayList<>();
        for (Patient patient : patients) {
            patientDTSList.add(patientToPatientDTS(patient));
        }
        return patientDTSList;
    }

    @Override
    public void add(PatientDTS patientDTS) throws ParseException, IncorrectNumPassportException {
        if (!(patientDTS.getNumPassport()).matches("\\d{8}")) {
            throw new IncorrectNumPassportException();
        } else if (!(patientDTS.getFIO()).matches("(([а-яА-Я]+)\\s)(([а-яА-Я]+)\\s)([а-яА-Я]+)")) {
            System.out.println("Некорректное ФИО пациента");
            return;
        }
        Patient patient = patientDTSToPatient(patientDTS);
        patientDao.add(patient);
    }

    @Override
    public void update(PatientDTS patientDTS) throws ParseException {
        if (!(patientDTS.getFIO()).matches("(([а-яА-Я]+)\\s)(([а-яА-Я]+)\\s)([а-яА-Я]+)")) {
            System.out.println("Некорректное ФИО пациента");
            return;
        }
        Patient patient = patientDTSToPatient(patientDTS);
        patientDao.update(patient);
    }

    @Override
    public void delete(String numPassport) {
        patientDao.delete(numPassport);
    }

    @Override
    public void deleteByPatientName(String patientName) {
        if (!(patientName.matches("(([а-яА-Я]+)\\s)(([а-яА-Я]+)\\s)([а-яА-Я]+)"))) {
            System.out.println("Некорректное имя пациента");
            return;
        }
        String correctCaseFIO = StringManip.setCorrectCaseForFIO(patientName);
        Patient patient = patientDao.getPatientByName(correctCaseFIO);
        patientDao.delete(patient.getNumPassport());
    }
}
