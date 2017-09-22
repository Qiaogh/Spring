package com.qiaogh.aop;

import java.util.Arrays;

import org.springframework.aop.framework.autoproxy.AbstractAdvisorAutoProxyCreator;

@SuppressWarnings( "serial" )
public class SimpleAdvisorAutoProxyCreator extends AbstractAdvisorAutoProxyCreator {

    private String[] excludes;
    
    public void setExcludes( String... excludes ) {
        this.excludes = excludes;
    }

    @Override
    protected boolean shouldSkip( Class<?> beanClass, String beanName ) {
        return excludes != null && Arrays.binarySearch( excludes, beanName ) >= 0;
    }
}
