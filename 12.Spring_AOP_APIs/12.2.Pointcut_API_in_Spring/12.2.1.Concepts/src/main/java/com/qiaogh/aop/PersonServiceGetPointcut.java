package com.qiaogh.aop;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;

public class PersonServiceGetPointcut implements Pointcut {

    @Override
    public ClassFilter getClassFilter() {
        return TRUE.getClassFilter();
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return TRUE.getMethodMatcher();
    }
}
