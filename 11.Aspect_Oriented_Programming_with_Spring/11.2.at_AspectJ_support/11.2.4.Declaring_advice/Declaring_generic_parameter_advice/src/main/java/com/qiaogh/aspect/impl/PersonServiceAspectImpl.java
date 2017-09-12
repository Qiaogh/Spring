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
import org.springframework.util.Assert;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.domain.Person;

@Aspect
@Component
public class PersonServiceAspectImpl implements PersonServiceAspect {

    @Pointcut( "execution(public * com.qiaogh.service.GenericService+.get(String))" )
    public void doGetPointcut() {}
    @Pointcut( "execution(public void com.qiaogh.service.GenericService+.update(*))" )
    public void doUpdatePointcut() {}
    
    @Override
    @Before( value = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut() && args( id )", argNames = "id" )
    public void beforeGet( String id ) {
        INVOKED_ADVICES.put( BEFORE_GET, id );
    }

    @Override
    @After( value = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut() && args( id )", argNames = "id" )
    public void afterGet( String id ) {
        INVOKED_ADVICES.put( AFTER_GET, id );
    }

    @Override
    @AfterReturning( pointcut = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut()", argNames = "person", returning = "person" )
    public void afterGetReturning( Person person ) {
        Assert.notNull( person, "Person cannot be null!" );
        LOADED_PERSONS.add( person );
        INVOKED_ADVICES.put( AFTER_GET_RETURNING, person );
    }

    @Override
    @AfterThrowing( pointcut = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut()", argNames = "ex", throwing = "ex" )
    public void afterGetThrowing( RuntimeException ex ) {
        THORWED_EXCEPTIONS.add( ex );
    }

    @Override
    @Around( value = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doUpdatePointcut() && args( person )",
             // JoinPoint 的子类参数可以不用在 argNames 中指定
             argNames = "person" )
    public Object aroundUpdate( ProceedingJoinPoint point, Person person ) throws Throwable {
        INVOKED_ADVICES.put( AROUND_UPDATE, person );
        UPDATED_PERSONS.add( person );
        return point.proceed();
    }
}
