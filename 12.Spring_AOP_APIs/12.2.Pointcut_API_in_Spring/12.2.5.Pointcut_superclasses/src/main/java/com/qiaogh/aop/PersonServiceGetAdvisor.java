package com.qiaogh.aop;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

import com.qiaogh.service.PersonService;

@SuppressWarnings( "serial" )
public class PersonServiceGetAdvisor extends StaticMethodMatcherPointcutAdvisor {

    public static final String GET = "get";
    
    @Override
    public boolean matches( Method method, Class<?> targetClass ) {
        return PersonService.class.isAssignableFrom( targetClass ) && GET.equals( method.getName() );
    }
}
