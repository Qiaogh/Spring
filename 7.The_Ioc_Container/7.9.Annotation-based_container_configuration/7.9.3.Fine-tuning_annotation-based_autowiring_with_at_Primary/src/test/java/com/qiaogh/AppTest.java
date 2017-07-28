package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Husband;
import com.qiaogh.domain.Wife;

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
        Husband husband = cxt.getBean( Husband.class );
        Wife wife = cxt.getBean( Wife.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertNotNull( husband.getWife() );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( "Qiy", husband.getWife().getName() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
