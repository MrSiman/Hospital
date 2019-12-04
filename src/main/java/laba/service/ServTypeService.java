package laba.service;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.ServiceType;

import java.util.List;

public interface ServTypeService {
    public List<ServiceType> findAll();
    public ServiceType getByTypeServiceCode(String typeServiceCode);
    public void add(ServiceType serviceType) throws IncorrectCodeException, IncorrectNameException;
    public void delete (String typeServiceCode);
    public void update(ServiceType serviceType) throws IncorrectNameException;
}
