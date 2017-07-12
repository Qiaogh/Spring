package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Woman;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        Man qiaogh = (Man) cxt.getBean( "qiaogh" );
        Woman qiy = cxt.getBean( Woman.class );
        Assert.assertNotNull( qiaogh );
        Assert.assertNotNull( qiy );
        Assert.assertEquals( qiy, qiaogh.getWife() );
        Assert.assertEquals( qiaogh, qiy.getHusband() );
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
