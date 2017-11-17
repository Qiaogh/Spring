package com.qiaogh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

@Service( PersonService.SERVICE_KEY )
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    
    @Override
    public int count() {
        return personDao.count();
    }

    @Override
    public Integer save( Person person ) {
        return personDao.save( person );
    }

    @Override
    public void delete( Integer id ) {
        personDao.delete( id );
    }

    @Override
    public void update( Person person ) {
        personDao.update( person );
    }

    @Override
    public Person get( Integer id ) {
        return personDao.get( id );
    }
    
    @Override
    public String getName( Integer id ) {
        return personDao.getName( id );
    }

    @Override
    public List<Person> query() {
        return personDao.query();
    }

    public PersonDao getPersonDao() {
        return personDao;
    }

    @Autowired
    public void setPersonDao( PersonDao personDao ) {
        this.personDao = personDao;
    }
}
