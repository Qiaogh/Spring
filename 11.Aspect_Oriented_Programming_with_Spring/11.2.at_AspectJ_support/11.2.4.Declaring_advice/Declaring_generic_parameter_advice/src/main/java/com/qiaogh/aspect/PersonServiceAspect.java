package com.qiaogh.aspect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

import com.qiaogh.domain.Person;

public interface PersonServiceAspect {

    String BEFORE_GET = "before_get";
    String AFTER_GET_RETURNING = "after_get_returning";
    String AFTER_GET = "after_get";
    String AFTER_GET_THROWING = "after_get_throwing";
    String AROUND_UPDATE = "around_update";
    
    Map<String, Object> INVOKED_ADVICES = new HashMap<String, Object>();
    List<Person> LOADED_PERSONS = new ArrayList<Person>();
    List<Exception> THORWED_EXCEPTIONS = new ArrayList<Exception>();
    List<Person> UPDATED_PERSONS = new ArrayList<Person>();
    
    public void beforeGet( String id );
    public void afterGet( String id );
    public void afterGetReturning( Person person );
    public void afterGetThrowing( RuntimeException ex );
    public Object aroundUpdate( ProceedingJoinPoint point, Person person ) throws Throwable;
}
