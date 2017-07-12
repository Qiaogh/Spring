package com.qiaogh;

import com.qiaogh.domain.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testCircularDependencies() {
        Person qiaogh = (Person) cxt.getBean( "qiaogh" );
        Assert.assertNotNull( qiaogh );
        Assert.assertNotNull( qiaogh.getChilds() );
        Assert.assertTrue( !qiaogh.getChilds().isEmpty() );
        Assert.assertEquals( 3, qiaogh.getChilds().size() );
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
