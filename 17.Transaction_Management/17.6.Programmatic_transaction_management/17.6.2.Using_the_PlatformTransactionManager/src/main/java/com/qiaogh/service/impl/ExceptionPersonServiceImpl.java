package com.qiaogh.service.impl;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.PersonService;

public class ExceptionPersonServiceImpl extends PersonServiceImpl implements PersonService {

    @Override
    public void save( Person person ) {
        super.save( person );
        throw new RollbackForException();
    }
}
