package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Husband;
import com.qiaogh.domain.Son;
import com.qiaogh.domain.Wife;

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
        Husband husband = cxt.getBean( Husband.class );
        Wife qiy = (Wife) cxt.getBean( "qiy" );
        Son qiaoxl = (Son) cxt.getBean( "qiaoxl" );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( qiy );
        Assert.assertNotNull( qiaoxl );
        Assert.assertNotNull( husband.getWife() );
        Assert.assertEquals( qiy, husband.getWife() );
        Assert.assertEquals( qiaoxl, husband.getSon() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
