package com.qiaogh.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.Assert;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.domain.Person;

public class PersonServiceAspectImpl implements PersonServiceAspect {

    public void doGetPointcut() {}
    public void doUpdatePointcut() {}
    
    @Override
    public void beforeGet() {
        INVOKED_ADVICES.put( BEFORE_GET, null );
    }

    @Override
    public void afterGet() {
        INVOKED_ADVICES.put( AFTER_GET, null );
    }

    @Override
    public void afterGetReturning( Person person ) {
        Assert.notNull( person, "Person cannot be null!" );
        LOADED_PERSONS.add( person );
        INVOKED_ADVICES.put( AFTER_GET_RETURNING, null );
    }

    @Override
    public void afterGetThrowing( RuntimeException ex ) {
        THORWED_EXCEPTIONS.add( ex );
    }

    @Override
    public Object aroundUpdate( ProceedingJoinPoint point, Person person ) throws Throwable {
        INVOKED_ADVICES.put( AROUND_UPDATE, null );
        UPDATED_PERSONS.add( person );
        return point.proceed();
    }
}
