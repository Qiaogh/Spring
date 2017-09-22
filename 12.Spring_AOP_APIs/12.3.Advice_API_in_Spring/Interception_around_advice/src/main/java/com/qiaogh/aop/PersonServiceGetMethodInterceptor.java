package com.qiaogh.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class PersonServiceGetMethodInterceptor implements MethodInterceptor {

    public static boolean INVOKED = false;
    
    @Override
    public Object invoke( MethodInvocation invocation ) throws Throwable {
        INVOKED = true;
        return invocation.proceed();
    }
}
