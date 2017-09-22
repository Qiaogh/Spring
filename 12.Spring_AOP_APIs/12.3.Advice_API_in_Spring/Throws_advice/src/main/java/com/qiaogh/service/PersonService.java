package com.qiaogh.service;

import java.beans.Introspector;

import com.qiaogh.domain.Person;
import com.qiaogh.util.ResponseMessage;

public interface PersonService extends ResponseMessage {

    String SERVICEKEY = Introspector.decapitalize( PersonService.class.getSimpleName() );
    
    Person get( String id );
}
