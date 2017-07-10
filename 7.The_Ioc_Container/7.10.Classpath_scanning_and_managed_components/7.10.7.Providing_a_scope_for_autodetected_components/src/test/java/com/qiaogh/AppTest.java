package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Man;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClassPathXmlApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        Man husband1 = cxt.getBean( Man.class );
        Man husband2 = cxt.getBean( Man.class );
        Assert.assertEquals( husband1, husband2 );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
