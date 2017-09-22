package com.qiaogh.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MethodAfterAdviceInterceptor implements MethodInterceptor {

    private final MethodAfterAdvice advice;
    
    public MethodAfterAdviceInterceptor( MethodAfterAdvice advice ) {
        this.advice = advice;
    }

    @Override
    public Object invoke( MethodInvocation invocation ) throws Throwable {
        Object retVal = invocation.proceed();
        advice.after( invocation.proceed() );
        return retVal;
    }

}
