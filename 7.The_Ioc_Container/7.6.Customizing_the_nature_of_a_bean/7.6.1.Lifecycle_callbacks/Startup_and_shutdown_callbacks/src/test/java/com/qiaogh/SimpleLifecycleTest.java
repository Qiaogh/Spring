package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class SimpleLifecycleTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        Assert.assertNotNull( SimpleLifecycle.START_FLAG );
        Assert.assertEquals( SimpleLifecycle.START_STATUS, SimpleLifecycle.START_FLAG );
        
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (AbstractApplicationContext) cxt ).destroy();
        }
        Assert.assertNotNull( SimpleLifecycle.STOP_FLAG );
        Assert.assertEquals( SimpleLifecycle.STOP_STATUS, SimpleLifecycle.STOP_FLAG );
    }
}
