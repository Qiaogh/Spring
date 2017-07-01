package com.qiaogh;

import com.qiaogh.domain.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testCircularDependencies() {
        Person qiaogh = (Person) cxt.getBean( "qiaogh" );
        Assert.assertNotNull( qiaogh );
        Assert.assertNotNull( qiaogh.getWife() );
        Assert.assertNotNull( qiaogh.getWife().getId() );
        Assert.assertNotNull( qiaogh.getWife().getName() );
        Assert.assertEquals( "2", qiaogh.getWife().getId() );
        Assert.assertEquals( "Qiy", qiaogh.getWife().getName() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
