package laba.service;

import laba.dao.CompleteServicesDao;
import laba.objects.CompleteServices;
import laba.objects.CompleteServicesDTS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CompleteServServiceImp implements CompleteServService {
    @Autowired
    CompleteServicesDao completeServicesDao;

    @Override
    public CompleteServicesDTS CSToCSDTS(CompleteServices completeServices) {
        DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dateFormat2 = new SimpleDateFormat("hh:mm");
        String dateComplete = dateFormat1.format(completeServices.getDateComplete());
        String timeBegin = dateFormat2.format(completeServices.getTimeBegin());
        String timeEnd = dateFormat2.format(completeServices.getTimeEnd());
        CompleteServicesDTS servicesDTS = new CompleteServicesDTS(completeServices.getId(), completeServices.getServiceName(),completeServices.getNameDoctor(), completeServices.getNamePatient(), dateComplete, timeBegin, timeEnd, completeServices.getCost());
        return servicesDTS;
    }

    @Override
    public CompleteServices CSDTSToCS(CompleteServicesDTS completeServicesDTS) throws ParseException {
        DateFormat dateFormat1 = new SimpleDateFormat("dd.MM.yyyy");
        DateFormat dateFormat2 = new SimpleDateFormat("hh:mm");
        Date dateComplete = dateFormat1.parse(completeServicesDTS.getDateComplete());
        Date timeBegin = dateFormat2.parse(completeServicesDTS.getTimeBegin());
        Date timeEnd = dateFormat2.parse(completeServicesDTS.getTimeEnd());
        CompleteServices services = new CompleteServices(completeServicesDTS.getServiceName(), completeServicesDTS.getNameDoctor(), completeServicesDTS.getNamePatient(), dateComplete, timeBegin, timeEnd, completeServicesDTS.getCost());
        return services;
    }

    @Override
    public List<CompleteServicesDTS> findAll() {
        List<CompleteServices> completeServicesList = completeServicesDao.findAll();
        List<CompleteServicesDTS> completeServicesDTSList = new ArrayList<>();
        for (CompleteServices CService : completeServicesList) {
            completeServicesDTSList.add(CSToCSDTS(CService));
        }
        return completeServicesDTSList;
    }

    @Override
    public List<CompleteServicesDTS> findByPatientName(String patientName) {
        List<CompleteServices> completeServicesList = completeServicesDao.findByPatientName(patientName);
        List<CompleteServicesDTS> completeServicesDTSList = new ArrayList<>();
        for (CompleteServices CService : completeServicesList) {
            completeServicesDTSList.add(CSToCSDTS(CService));
        }
        return completeServicesDTSList;
    }

    @Override
    public List<CompleteServicesDTS> findByDoctorName(String doctorName) {
        List<CompleteServices> completeServicesList = completeServicesDao.findByDoctorName(doctorName);
        List<CompleteServicesDTS> completeServicesDTSList = new ArrayList<>();
        for (CompleteServices CService : completeServicesList) {
            completeServicesDTSList.add(CSToCSDTS(CService));
        }
        return completeServicesDTSList;
    }

    @Override
    public void add(CompleteServicesDTS completeServicesDTS) throws ParseException{
        CompleteServices completeServices = CSDTSToCS(completeServicesDTS);
        completeServicesDao.add(completeServices);
    }

    @Override
    public void update(CompleteServicesDTS completeServicesDTS) throws ParseException {
        CompleteServices completeServices = CSDTSToCS(completeServicesDTS);
        completeServicesDao.update(completeServices);
    }

    @Override
    public void delete(int id) {
        completeServicesDao.delete(id);
    }
}
