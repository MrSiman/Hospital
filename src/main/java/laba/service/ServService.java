package laba.service;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectCostException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Service;

import java.util.List;

public interface ServService {
    public List<Service> findAll();
    public Service getByCode(String code);
    public void add(Service service) throws IncorrectCodeException, IncorrectNameException, IncorrectCostException;
    public void update(Service service) throws IncorrectNameException, IncorrectCostException;
    public void delete(String code);
}
