package com.qiaogh.service.impl;

import org.springframework.stereotype.Service;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

@Service( "personService" )
public class PersonServiceImpl extends GenericServiceImpl<Person> implements PersonService {

    {
        caches.put( "1", new Person( "1", "Qiaogh", 26 ) );
        caches.put( "2", new Person( "2", "Qiy", 24 ) );
        caches.put( "3", null );
    }
}
