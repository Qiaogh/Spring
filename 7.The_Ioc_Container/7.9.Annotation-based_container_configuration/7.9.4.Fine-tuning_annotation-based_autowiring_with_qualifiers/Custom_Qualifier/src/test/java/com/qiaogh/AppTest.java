package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Daughter;
import com.qiaogh.domain.Husband;
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
        Wife wife = (Wife) cxt.getBean( "qiy" );
        Daughter qiaoxh = (Daughter) cxt.getBean( "qiaoxh" );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertNotNull( qiaoxh );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( qiaoxh, husband.getQiaoxh() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
