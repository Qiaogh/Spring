package com.qiaogh.service;

import com.qiaogh.domain.Person;

public interface SimpleExceptionPersonService extends PersonService {

    void exUpdate( Person person );
    void exDelete( Integer id );
}
