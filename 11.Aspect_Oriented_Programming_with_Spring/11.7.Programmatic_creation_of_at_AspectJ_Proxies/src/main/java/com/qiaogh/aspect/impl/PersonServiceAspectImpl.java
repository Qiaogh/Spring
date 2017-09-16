package com.qiaogh.aspect.impl;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.qiaogh.aspect.PersonServiceAspect;

@Aspect
@Component
public class PersonServiceAspectImpl implements PersonServiceAspect {

    @Pointcut( "execution(public com.qiaogh.domain.Person com.qiaogh.service.PersonService.get(String))" )
    public void doGetPointcut() {}
    
    @Override
    @Before( value = "com.qiaogh.aspect.SystemArchitecture.inServiceLayer() && doGetPointcut()" )
    public void beforeGet() {
        INVOKED_ADVICES.put( BEFORE_GET, null );
    }
}
