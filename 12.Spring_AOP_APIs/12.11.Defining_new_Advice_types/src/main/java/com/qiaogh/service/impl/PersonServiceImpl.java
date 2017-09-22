package com.qiaogh.service.impl;

import java.util.HashMap;
import java.util.Map;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

public class PersonServiceImpl implements PersonService {
    
    private Map<String, Person> persons = new HashMap<String, Person>();
    
    {
        persons.put( "1", new Person( "1", "Qiaogh", 26 ) );
        persons.put( "2", new Person( "2", "Qiy", 24 ) );
    }

    @Override
    public Person get( String id ) {
        return persons.get( id );
    }
}
