package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.PropertyOverrideConfigurerPerson;

/**
 * Unit test for simple App.
 */
public class PropertyOverrideConfigurerTest {

    private ClassPathXmlApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        PropertyOverrideConfigurerPerson person = cxt.getBean( PropertyOverrideConfigurerPerson.class );
        Assert.assertNotNull( person );
        Assert.assertEquals( "1", person.getId() );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 25 ), person.getAge() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
