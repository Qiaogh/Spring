package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;

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
        Person first = cxt.getBean( Person.class );
        Person second = cxt.getBean( Person.class );
        Assert.assertNotSame( first, second );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
