package com.qiaogh.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.qiaogh.dao.PersonDao;
import com.qiaogh.domain.Person;

@Repository
public class HibernatePersonDaoImpl extends HibernateTemplate implements PersonDao {

    @Override
    public void save( Person person ) {
        super.save( person );
    }

    @Override
    @Autowired
    public void setSessionFactory( SessionFactory sessionFactory ) {
        super.setSessionFactory( sessionFactory );
    }
}
