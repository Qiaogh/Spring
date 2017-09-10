package com.qiaogh.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.CannotFindPersonException;
import com.qiaogh.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

    private Map<String, Person> persons = new HashMap<String, Person>();
    
    {
        persons.put( "1", new Person( "1", "Qiaogh", 26 ) );
        persons.put( "2", new Person( "2", "Qiy", 24 ) );
        persons.put( "3", null );
    }
    
    @Override
    public Person get( String id ) {
        checkPersonExists( id );
        return persons.get( id );
    }

    @Override
    public void update( Person person ) {
        Assert.notNull( person, "Person cannot be null!" );
        checkPersonExists( person.getId() );
        persons.put( person.getId(), person );
    }
    
    private void checkPersonExists( String id ) {
        if ( !persons.containsKey( id ) ) {
            throw new CannotFindPersonException( id );
        }
    }
}
