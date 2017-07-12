package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;
import com.qiaogh.factory.WifeFactory;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( Man.class, WifeFactory.class );
    }

    @Test
    public void test() {
        Man husband = cxt.getBean( Man.class );
        Women wife = cxt.getBean( "qiy", Women.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( husband, wife.getHusband() );
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
