package com.qiaogh.service.impl;

import com.qiaogh.domain.Person;
import com.qiaogh.service.ExceptionPersonService;

public class ExceptionPersonServiceImpl extends PersonServiceImpl implements ExceptionPersonService {

    @Override
    public void exUpdate( Person person, RuntimeException e ) {
        update( person );
        throw e;
    }
}
