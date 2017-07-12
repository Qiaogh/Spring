package com.qiaogh;

import com.qiaogh.domain.Person;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.DateFormat;
import java.util.Date;

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
    public void testInstantiatingBeansWithConstructor() throws Exception {
        Person person = (Person) cxt.getBean( "person" );
        Assert.assertTrue( Integer.valueOf( 1 ).equals( person.getId() ) );
        Assert.assertTrue( "Qiaogh".equals( person.getName() ) );
        Assert.assertTrue( Integer.valueOf( 26 ).equals( person.getAge() ) );
        Assert.assertTrue( Integer.valueOf( 178 ).equals( person.getHeight() ) );
        Assert.assertTrue( DateFormat.getDateInstance().parse( "1991-10-07" ).equals( person.getBirthday() ) );
    }

    @Test
    @SuppressWarnings( "unchecked" )
    public void testInstantiatingBeansWithFactoryMethod() {
        Class<Integer> clazz = (Class<Integer>) cxt.getBean( "listClass" );
        Assert.assertTrue( Integer.class.equals( clazz ) );
    }

    @Test
    public void testInstantiatingBeansWithInstanceFactoryMethod() {
        Date date = (Date) cxt.getBean( "date" );
        Assert.assertNotNull( date );
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
