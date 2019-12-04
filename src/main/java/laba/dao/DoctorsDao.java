package laba.dao;

import laba.objects.Doctor;

import java.util.List;

public interface DoctorsDao {
    public List<Doctor> findAll();
    public Doctor getDoctorByPassport(String numPassport);
    public void add(Doctor doctor);
    public void update(Doctor doctor);
    public void delete(String numPassport);
}
