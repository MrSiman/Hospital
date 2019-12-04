package laba.service;

import laba.dao.ProfessionDao;
import laba.exceptions.IncorrectCodeException;
import laba.exceptions.IncorrectNameException;
import laba.objects.Profession;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProfessionServiceImp implements ProfessionService {

    @Autowired
    private ProfessionDao professionDao;

    @Override
    public List<Profession> findAll() {
        return professionDao.findAll();
    }

    @Override
    public Profession getByCode(String code) {
        return professionDao.getByCode(code);
    }

    @Override
    public void add(Profession profession) throws IncorrectCodeException, IncorrectNameException {
        if (!(profession.getCode().matches("\\d{6}"))) {
            throw new IncorrectCodeException();
        } else if (!(profession.getName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        }
        String rightCaseProfName = StringManip.setCorrectCaseForOtherWords(profession.getName());
        profession.setName(rightCaseProfName);
        professionDao.add(profession);
    }

    @Override
    public void delete(String code) {
        professionDao.delete(code);
    }

    @Override
    public void update(Profession profession) throws IncorrectNameException{
        if (!(profession.getName().matches("((([а-яА-Я]+)\\s)+)([а-яА-Я]+)"))) {
            throw new IncorrectNameException();
        }
        String rightCaseProfName = StringManip.setCorrectCaseForOtherWords(profession.getName());
        profession.setName(rightCaseProfName);
        professionDao.update(profession);
    }
}
