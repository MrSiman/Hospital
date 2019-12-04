package laba.dao;

import laba.objects.Profession;

import java.util.List;

public interface ProfessionDao {
    public List<Profession> findAll();
    public Profession getByCode(String code);
    public void add(Profession profession);
    public void delete(String code);
    public void update(Profession profession);
}
