package laba.service;

import laba.exceptions.IncorrectFioException;
import laba.exceptions.IncorrectNumPassportException;
import laba.exceptions.IncorrectSalaryException;
import laba.objects.Doctor;

import java.util.List;

public interface DoctorsService {
    public List<Doctor> findAll();
    public Doctor getDoctorByPassport(String numPassport);
    public void add(Doctor doctor) throws IncorrectNumPassportException, IncorrectFioException, IncorrectSalaryException;
    public void update(Doctor doctor) throws IncorrectFioException, IncorrectSalaryException;
    public void delete(String numPassport);
}
