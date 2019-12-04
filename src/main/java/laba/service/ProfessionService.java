package laba.service;

import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Profession;

import java.util.List;

public interface ProfessionService {
    public List<Profession> findAll();
    public Profession getByCode(String code);
    public void add(Profession profession) throws IncorrectCodeException, IncorrectNameException;
    public void delete(String code);
    public void update(Profession profession) throws IncorrectNameException;
}
