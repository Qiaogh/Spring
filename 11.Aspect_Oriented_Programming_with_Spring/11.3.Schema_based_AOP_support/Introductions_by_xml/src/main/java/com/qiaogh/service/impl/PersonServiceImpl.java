package com.qiaogh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.Assert;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private Map<String, Person> persons = new HashMap<String, Person>();
    
    @Override
    public void save( Person person ) {
        Assert.notNull( person, "person can not be null!" );
        persons.put( person.getId(), person );
    }
}
