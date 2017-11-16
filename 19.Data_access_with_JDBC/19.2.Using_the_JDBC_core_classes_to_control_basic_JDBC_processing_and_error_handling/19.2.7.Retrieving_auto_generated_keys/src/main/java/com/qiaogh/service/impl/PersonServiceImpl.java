package com.qiaogh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;
    
    @Override
    public Integer save( Person person ) {
        return personDao.save( person );
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
