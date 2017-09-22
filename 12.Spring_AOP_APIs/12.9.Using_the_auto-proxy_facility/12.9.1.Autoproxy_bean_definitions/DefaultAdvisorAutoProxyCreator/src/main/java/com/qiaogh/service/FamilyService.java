package com.qiaogh.service;

import java.beans.Introspector;

import com.qiaogh.domain.Family;

public interface FamilyService {

    String SERVIEKEY = Introspector.decapitalize( FamilyService.class.getSimpleName() );
    
    Family get( String id );
}
