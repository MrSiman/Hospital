package laba.service;

import laba.dao.ServiceTypeDao;
import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServTypeServiceImp implements ServTypeService {

    @Autowired
    private ServiceTypeDao serviceTypeDao;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeDao.findAll();
    }

    @Override
    public ServiceType getByTypeServiceCode(String typeServiceCode) {
        return serviceTypeDao.getByTypeServiceCode(typeServiceCode);
    }

    @Override
    public void add(ServiceType serviceType) throws IncorrectCodeException, IncorrectNameException {
        if (!(serviceType.getTypeServiceCode().matches("\\d{6}"))) {
            throw new IncorrectCodeException();
        } else if(!(serviceType.getTypeName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        }
        String correctCaseTypeName = StringManip.setCorrectCaseForOtherWords(serviceType.getTypeName());
        serviceType.setTypeName(correctCaseTypeName);
        serviceTypeDao.add(serviceType);
    }

    @Override
    public void delete(String typeServiceCode) {
        serviceTypeDao.delete(typeServiceCode);
    }

    @Override
    public void update(ServiceType serviceType) throws IncorrectNameException{
        if(!(serviceType.getTypeName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        }
        String correctCaseTypeName = StringManip.setCorrectCaseForOtherWords(serviceType.getTypeName());
        serviceType.setTypeName(correctCaseTypeName);
        serviceTypeDao.update(serviceType);
    }
}
