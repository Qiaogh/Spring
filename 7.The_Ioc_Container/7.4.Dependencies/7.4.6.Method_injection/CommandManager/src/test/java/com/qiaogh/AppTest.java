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
    public void test() {
        com.qiaogh.domain.Class clazz = (com.qiaogh.domain.Class) cxt.getBean( "class" );
        Assert.assertNotNull( clazz );
        Assert.assertNotEquals( clazz.play(), clazz.play() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
