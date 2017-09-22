package com.qiaogh.aop;

import java.beans.Introspector;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.MethodBeforeAdvice;

public class BeforeGetMethodAdvice implements MethodBeforeAdvice {

    public static Map<String, Object> CACHED_SERVICE = new HashMap<String, Object>();
    
    @Override
    public void before( Method method, Object[] args, Object target ) throws Throwable {
        String key = Introspector.decapitalize( method.getDeclaringClass().getSimpleName() );
        CACHED_SERVICE.put( key, target );
    }

}
