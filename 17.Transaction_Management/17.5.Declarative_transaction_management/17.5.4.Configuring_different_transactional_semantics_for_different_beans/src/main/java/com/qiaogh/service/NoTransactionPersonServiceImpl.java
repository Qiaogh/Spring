package com.qiaogh.service;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.impl.PersonServiceImpl;

public class NoTransactionPersonServiceImpl extends PersonServiceImpl implements PersonService {

    @Override
    public void save( Person person ) {
        super.save( person );
        throw new RollbackForException();
    }
}
