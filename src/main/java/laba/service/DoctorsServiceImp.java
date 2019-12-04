package laba.service;

import laba.dao.DoctorsDao;
import laba.exceptions.IncorrectFioException;
import laba.exceptions.IncorrectNumPassportException;
import laba.exceptions.IncorrectSalaryException;
import laba.objects.Doctor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DoctorsServiceImp implements DoctorsService {

    @Autowired
    private DoctorsDao doctorsDao;

    @Override
    public List<Doctor> findAll() {
        return doctorsDao.findAll();
    }

    @Override
    public Doctor getDoctorByPassport(String numPassport){
        return doctorsDao.getDoctorByPassport(numPassport);
    }

    @Override
    public void add(Doctor doctor) throws IncorrectNumPassportException, IncorrectFioException, IncorrectSalaryException {
        if (!(doctor.getNumPassport().matches("\\d{8}"))) {
            throw new IncorrectNumPassportException();
        } else if (!(doctor.getFIO().matches("(([а-яА-Я]+)\\s)(([а-яА-Я]+)\\s)([а-яА-Я]+)"))) {
            throw new IncorrectFioException();
        } else if (doctor.getSalary() <= 0) {
            throw new IncorrectSalaryException();
        }
        String correctCaseFIO = StringManip.setCorrectCaseForFIO(doctor.getFIO());
        doctor.setFIO(correctCaseFIO);
        doctorsDao.add(doctor);
    }

    @Override
    public void update(Doctor doctor) throws IncorrectFioException, IncorrectSalaryException {
        if (!(doctor.getFIO().matches("(([а-яА-Я]+)\\s)(([а-яА-Я]+)\\s)([а-яА-Я]+)"))) {
            throw new IncorrectFioException();
        } else if (doctor.getSalary() <= 0) {
            throw new IncorrectSalaryException();
        }
        String correctCaseFIO = StringManip.setCorrectCaseForFIO(doctor.getFIO());
        doctor.setFIO(correctCaseFIO);
        doctorsDao.update(doctor);
    }

    @Override
    public void delete(String numPassport) {
        doctorsDao.delete(numPassport);
    }

}
