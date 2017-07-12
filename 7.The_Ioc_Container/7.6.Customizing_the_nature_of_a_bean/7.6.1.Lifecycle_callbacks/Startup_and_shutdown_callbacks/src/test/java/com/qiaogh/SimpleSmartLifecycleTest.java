package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleSmartLifecycleTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        Assert.assertNotNull( SimpleSmartLifecycle.START_FLAG );
        Assert.assertEquals( SimpleSmartLifecycle.START_STATUS, SimpleSmartLifecycle.START_FLAG );
        
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (AbstractApplicationContext) cxt ).destroy();
        }
        Assert.assertNotNull( SimpleSmartLifecycle.STOP_FLAG );
        Assert.assertEquals( SimpleSmartLifecycle.STOP_FLAG, SimpleSmartLifecycle.CALLBACK_STOP_STATUS );
    }
}
