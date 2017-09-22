package com.qiaogh.service.impl;

import com.qiaogh.domain.Person;
import com.qiaogh.exceptions.CannotFindPersonException;
import com.qiaogh.service.PersonService;

public class PersonServiceCheckNotNullImpl implements PersonService {

    private PersonService personService;
    
    @Override
    public Person get( String id ) throws IllegalArgumentException, CannotFindPersonException {
        Person person = personService.get( id );
        if ( person == null ) {
            throw new CannotFindPersonException( id, String.format( CANNOT_FIND_PERSON, id ) );
        }
        return person;
    }

    public PersonService getPersonService() {
        return personService;
    }

    public void setPersonService( PersonService personService ) {
        this.personService = personService;
    }
}
