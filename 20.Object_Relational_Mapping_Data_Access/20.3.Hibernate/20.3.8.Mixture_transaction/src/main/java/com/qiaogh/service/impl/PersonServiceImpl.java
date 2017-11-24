package com.qiaogh.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.dao.impl.HibernatePersonDaoImpl;
import com.qiaogh.dao.impl.SpringJdbcPersonDaoImpl;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

@Service( PersonService.SERVICE_KEY )
public class PersonServiceImpl implements PersonService {

    private PersonDao hibernatePersonDao;
    private PersonDao springJdbcPersonDao;
    
    @Override
    public void save( Person person ) {
        springJdbcPersonDao.save( person );
        hibernatePersonDao.save( person );
    }
    
    public PersonDao getHibernatePersonDao() {
        return hibernatePersonDao;
    }

    @Resource( type = HibernatePersonDaoImpl.class )
    public void setHibernatePersonDao( PersonDao hibernatePersonDao ) {
        this.hibernatePersonDao = hibernatePersonDao;
    }

    public PersonDao getSpringJdbcPersonDao() {
        return springJdbcPersonDao;
    }

    @Resource( type = SpringJdbcPersonDaoImpl.class )
    public void setSpringJdbcPersonDao( PersonDao springJdbcPersonDao ) {
        this.springJdbcPersonDao = springJdbcPersonDao;
    }
}
