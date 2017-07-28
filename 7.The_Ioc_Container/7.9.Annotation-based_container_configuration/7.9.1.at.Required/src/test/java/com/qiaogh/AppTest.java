package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;

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
        Person person = cxt.getBean( Person.class );
        Assert.assertNotNull( person );
        Assert.assertNotNull( person.getName() );
        Assert.assertEquals( "Qiaogh", person.getName() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
