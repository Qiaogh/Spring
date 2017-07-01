package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMessageSourceAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleMessageSourceAware simpleMessageSourceAware = SimpleApplicationContextAware.getBean( SimpleMessageSourceAware.class );
        Assert.assertNotNull( simpleMessageSourceAware );
    }
}
