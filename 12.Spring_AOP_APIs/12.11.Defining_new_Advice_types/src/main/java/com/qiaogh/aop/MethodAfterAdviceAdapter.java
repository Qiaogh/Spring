package com.qiaogh.aop;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.adapter.AdvisorAdapter;

public class MethodAfterAdviceAdapter implements AdvisorAdapter {

    @Override
    public boolean supportsAdvice( Advice advice ) {
        return advice instanceof MethodAfterAdvice;
    }

    @Override
    public MethodInterceptor getInterceptor( Advisor advisor ) {
        MethodAfterAdvice advice = (MethodAfterAdvice) advisor.getAdvice();
        return new MethodAfterAdviceInterceptor( advice );
    }

}
