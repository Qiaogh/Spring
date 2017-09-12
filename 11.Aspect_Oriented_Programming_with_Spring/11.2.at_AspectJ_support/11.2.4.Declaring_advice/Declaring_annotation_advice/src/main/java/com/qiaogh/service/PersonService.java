package com.qiaogh.service;

import java.beans.Introspector;

import com.qiaogh.domain.Person;

public interface PersonService {

    String SERVICEKEY = Introspector.decapitalize( PersonService.class.getSimpleName() );
    
    Person get( String id );
    
    void update( Person person );
}
