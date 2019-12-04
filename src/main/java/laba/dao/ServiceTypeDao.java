package laba.dao;

import laba.objects.ServiceType;

import java.util.List;

public interface ServiceTypeDao {
    public List<ServiceType> findAll();
    public ServiceType getByTypeServiceCode(String typeServiceCode);
    public void add(ServiceType serviceType);
    public void delete(String typeServiceCode);
    public void update(ServiceType serviceType);
}
