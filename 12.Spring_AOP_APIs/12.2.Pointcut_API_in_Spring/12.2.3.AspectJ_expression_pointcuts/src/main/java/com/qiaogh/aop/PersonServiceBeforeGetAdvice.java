package com.qiaogh.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;


public class PersonServiceBeforeGetAdvice implements MethodBeforeAdvice {

    public static boolean INVOKED = false;
    
    @Override
    public void before( Method method, Object[] args, Object target ) throws Throwable {
        INVOKED = true;
        method.invoke( target, args );
    }
    
}
