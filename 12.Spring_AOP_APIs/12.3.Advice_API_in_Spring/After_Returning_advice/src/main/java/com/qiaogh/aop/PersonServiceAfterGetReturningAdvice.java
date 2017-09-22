package com.qiaogh.aop;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.AfterReturningAdvice;

import com.qiaogh.domain.Person;

public class PersonServiceAfterGetReturningAdvice implements AfterReturningAdvice {

    public static Map<String, Person> LOADED_PERSONS = new HashMap<String, Person>();
    
    @Override
    public void afterReturning( Object returnValue, Method method, Object[] args, Object target ) throws Throwable {
        LOADED_PERSONS.put( args[0].toString(), (Person) returnValue );
    }
}
