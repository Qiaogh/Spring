package com.qiaogh.service;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.impl.PersonServiceImpl;

@Transactional
public class MixturePersonService extends PersonServiceImpl implements PersonService {

    public MixturePersonService( DataSource dataSource ) {
        setDataSource( dataSource );
    }
    
    @Override
    @Transactional( propagation = Propagation.NEVER )
    public void save( Person person ) {
        super.save( person );
        throw new RollbackForException();
    }
}
