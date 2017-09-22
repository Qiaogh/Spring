package com.qiaogh.aop.impl;

import com.qiaogh.aop.MethodAfterAdvice;

public class PersonServiceAfterGetAdvice implements MethodAfterAdvice {
    
    public static boolean INVOKED = false;

    @Override
    public void after( Object returnValue ) {
        INVOKED = true;
    }
}
