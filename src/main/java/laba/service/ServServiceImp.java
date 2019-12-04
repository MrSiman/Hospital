package laba.service;

import laba.dao.ServiceDao;
import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectCostException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ServServiceImp implements ServService {

    @Autowired
    private ServiceDao serviceDao;

    @Override
    public List<Service> findAll() {
        return serviceDao.findAll();
    }

    @Override
    public Service getByCode(String code) {
        return serviceDao.getByCode(code);
    }

    @Override
    public void add(Service service) throws IncorrectCodeException, IncorrectNameException, IncorrectCostException {
        if (!(service.getCode().matches("\\d{6}"))) {
            throw new IncorrectCodeException();
        } else if (!(service.getName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        } else if (service.getCost() < 0) {
            throw new IncorrectCostException();
        }
        String correctServiceName = StringManip.setCorrectCaseForOtherWords(service.getName());
        service.setName(correctServiceName);
        serviceDao.add(service);
    }

    @Override
    public void update(Service service) throws IncorrectNameException, IncorrectCostException{
        if (!(service.getName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        } else if (service.getCost() < 0) {
            throw new IncorrectCostException();
        }
        String correctServiceName = StringManip.setCorrectCaseForOtherWords(service.getName());
        service.setName(correctServiceName);
        serviceDao.update(service);
    }

    @Override
    public void delete(String code) {
        serviceDao.delete(code);
    }
}
