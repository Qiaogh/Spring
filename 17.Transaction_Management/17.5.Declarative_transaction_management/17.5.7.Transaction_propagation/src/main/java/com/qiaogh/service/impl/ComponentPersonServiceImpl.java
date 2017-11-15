package com.qiaogh.service.impl;

import java.util.List;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.NoRollbackForException;
import com.qiaogh.service.PersonService;

public class ComponentPersonServiceImpl implements PersonService {

    private PersonService basePersonService;
    private PersonService exPersonService;
    
    @Override
    public void save( Person person ) {
        try {
            exPersonService.save( person );
        } catch ( Exception e ) {
            basePersonService.save( person );
            throw new NoRollbackForException( e );
        }
    }

    @Override
    public void update( Person person ) {
        basePersonService.update( person );
    }

    @Override
    public void delete( Integer id ) {
        basePersonService.delete( id );
    }

    @Override
    public Person get( Integer id ) {
        return basePersonService.get( id );
    }

    @Override
    public List<Person> query() {
        return basePersonService.query();
    }

    public PersonService getBasePersonService() {
        return basePersonService;
    }

    public void setBasePersonService( PersonService basePersonService ) {
        this.basePersonService = basePersonService;
    }

    public PersonService getExPersonService() {
        return exPersonService;
    }

    public void setExPersonService( PersonService exPersonService ) {
        this.exPersonService = exPersonService;
    }
}