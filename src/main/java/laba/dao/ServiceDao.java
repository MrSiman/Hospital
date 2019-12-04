package laba.dao;

import laba.objects.Service;

import java.util.List;

public interface ServiceDao {
    public List<Service> findAll();
    public Service getByCode(String code);
    public void add(Service service);
    public void update(Service service);
    public void delete(String code);
}
