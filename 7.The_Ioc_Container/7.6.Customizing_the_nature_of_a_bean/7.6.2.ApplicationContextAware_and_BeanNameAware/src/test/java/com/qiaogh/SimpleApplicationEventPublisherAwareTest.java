package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleApplicationEventPublisherAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleApplicationEventPublisherAware simpleBeanNameAware = SimpleApplicationContextAware.getBean( SimpleApplicationEventPublisherAware.class );
        Assert.assertNotNull( simpleBeanNameAware );
    }
}
