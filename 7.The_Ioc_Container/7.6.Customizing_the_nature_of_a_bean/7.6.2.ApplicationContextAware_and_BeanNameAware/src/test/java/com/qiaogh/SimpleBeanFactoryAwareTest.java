package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleBeanFactoryAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleBeanFactoryAware simpleBeanFactoryAware = SimpleApplicationContextAware.getBean( SimpleBeanFactoryAware.class );
        Assert.assertNotNull( simpleBeanFactoryAware );
    }
}
