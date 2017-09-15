package com.qiaogh.service;

import com.qiaogh.domain.Person;

public interface PersonService {

    String SERVICEKEY = "personService";
    
    void save( Person person );
}
