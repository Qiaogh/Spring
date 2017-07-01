package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleResourceLoaderAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleResourceLoaderAware simpleResourceLoaderAware = SimpleApplicationContextAware.getBean( SimpleResourceLoaderAware.class );
        Assert.assertNotNull( simpleResourceLoaderAware );
    }
}
