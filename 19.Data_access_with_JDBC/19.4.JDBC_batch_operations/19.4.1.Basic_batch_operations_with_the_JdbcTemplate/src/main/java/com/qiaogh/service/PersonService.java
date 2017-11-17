package com.qiaogh.service;

import com.qiaogh.PersonPersistenceSupport;
import com.qiaogh.PersonQuerySupport;

public interface PersonService extends PersonQuerySupport, PersonPersistenceSupport {

    String SERVICE_KEY = "personService";
}
