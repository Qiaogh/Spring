package com.qiaogh.aop;

import org.aopalliance.aop.Advice;

public interface MethodAfterAdvice extends Advice {

    public void after( Object returnValue );
}
