package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleLoadTimeWeaverAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleLoadTimeWeaverAware simpleLoadTimeWeaverAware = SimpleApplicationContextAware.getBean( SimpleLoadTimeWeaverAware.class );
        Assert.assertNotNull( simpleLoadTimeWeaverAware );
    }
}
