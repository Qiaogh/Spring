package com.qiaogh.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class PersonServiceAfterGetReturningAdvice implements AfterReturningAdvice {
    
    public static boolean INVOKED = false;

    @Override
    public void afterReturning( Object returnValue, Method method, Object[] args, Object target ) throws Throwable {
        INVOKED = true;
    }
}
