package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.PropertyPlaceholderConfigurerPerson;

/**
 * Unit test for simple App.
 */
public class PropertyPlaceholderConfigurerTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        PropertyPlaceholderConfigurerPerson person = cxt.getBean( PropertyPlaceholderConfigurerPerson.class );
        Assert.assertNotNull( person );
        Assert.assertEquals( "1", person.getId() );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 25 ), person.getAge() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
