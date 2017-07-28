package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
    }

    @Test
    public void test() {
        Man husband = cxt.getBean( Man.class );
        Women wife = cxt.getBean( Women.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( husband, wife.getHusband() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
