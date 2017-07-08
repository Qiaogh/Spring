package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Son;
import com.qiaogh.domain.Women;

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
        Man husband = cxt.getBean( Man.class );
        Women wife = (Women) cxt.getBean( "qiy" );
        Son son = (Son) cxt.getBean( "qiaoxl" );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertNotNull( son );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( wife, son.getMother() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
