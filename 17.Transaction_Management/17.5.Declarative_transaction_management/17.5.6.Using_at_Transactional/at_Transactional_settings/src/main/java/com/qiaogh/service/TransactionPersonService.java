package com.qiaogh.service;

import javax.sql.DataSource;

import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.impl.PersonServiceImpl;

@Transactional
public class TransactionPersonService extends PersonServiceImpl implements PersonService {

    public TransactionPersonService( DataSource dataSource ) {
        setDataSource( dataSource );
    }
    
    @Override
    public void save( Person person ) {
        super.save( person );
        throw new RollbackForException();
    }
}
