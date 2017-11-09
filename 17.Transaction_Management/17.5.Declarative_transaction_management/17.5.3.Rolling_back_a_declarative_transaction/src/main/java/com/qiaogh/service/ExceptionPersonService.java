package com.qiaogh.service;

import com.qiaogh.domain.Person;

public interface ExceptionPersonService extends PersonService {

    void exUpdate( Person person, RuntimeException e );
}
