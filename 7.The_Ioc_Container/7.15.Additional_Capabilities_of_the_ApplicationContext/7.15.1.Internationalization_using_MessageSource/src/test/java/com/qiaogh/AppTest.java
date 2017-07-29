package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void testSimple() {
        String message = cxt.getMessage( "message", null, null );
        Assert.assertEquals( "Alligators rock!", message );
    }

    @Test
    public void testException() {
        String message = cxt.getMessage( "argument.required", new Object[] { "name" }, null );
        Assert.assertEquals( "The name argument is required.", message );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
