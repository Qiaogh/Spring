package com.qiaogh.advice;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class PersonServiceAdvice implements MethodBeforeAdvice {

    public static boolean INVOKED = false;
    
    @Override
    public void before( Method method, Object[] args, Object target ) throws Throwable {
        INVOKED = true;
    }
}
