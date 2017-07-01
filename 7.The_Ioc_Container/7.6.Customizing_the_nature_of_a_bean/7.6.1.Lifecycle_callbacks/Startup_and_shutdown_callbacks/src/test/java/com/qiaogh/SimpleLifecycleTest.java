package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class SimpleLifecycleTest {

    private ClassPathXmlApplicationContext cxt;

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
        cxt.destroy();
        Assert.assertNotNull( SimpleLifecycle.STOP_FLAG );
        Assert.assertEquals( SimpleLifecycle.STOP_STATUS, SimpleLifecycle.STOP_FLAG );
    }
}
