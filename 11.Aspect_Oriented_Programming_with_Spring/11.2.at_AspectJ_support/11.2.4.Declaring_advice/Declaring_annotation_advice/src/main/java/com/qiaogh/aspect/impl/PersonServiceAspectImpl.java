package com.qiaogh.aspect.impl;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.domain.Person;

@Aspect
@Component
public class PersonServiceAspectImpl implements PersonServiceAspect {

    @Pointcut( "execution(public com.qiaogh.domain.Person com.qiaogh.service.PersonService.get(String))" )
    public void doGetPointcut() {
    }

    @Pointcut( "execution(public void com.qiaogh.service.PersonService.update(com.qiaogh.domain.Person))" )
    public void doUpdatePointcut() {
    }

    @Override
    @Before( value = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut() && @target( service )" )
    public void beforeGet( Service service ) {
        INVOKED_ADVICES.put( BEFORE_GET, service );
    }

    @Override
    @After( "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut() && @target( service )" )
    public void afterGet( Service service ) {
        INVOKED_ADVICES.put( AFTER_GET, service );
    }

    @Override
    @AfterReturning( pointcut = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut() && @target( service )", returning = "person" )
    public void afterGetReturning( Service service, Person person ) {
        Assert.notNull( person, "Person cannot be null!" );
        LOADED_PERSONS.add( person );
        INVOKED_ADVICES.put( AFTER_GET_RETURNING, service );
    }

    @Override
    @AfterThrowing( pointcut = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut()", throwing = "ex" )
    public void afterGetThrowing( RuntimeException ex ) {
        THORWED_EXCEPTIONS.add( ex );
    }

    @Override
    @Around( "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doUpdatePointcut() && @target( service ) && args( person )" )
    public Object aroundUpdate( ProceedingJoinPoint point, Service service, Person person ) throws Throwable {
        INVOKED_ADVICES.put( AROUND_UPDATE, service );
        UPDATED_PERSONS.add( person );
        return point.proceed();
    }
}
