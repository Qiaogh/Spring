package com.qiaogh;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

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
        PersonService personService = cxt.getBean( PersonService.class );
        Assert.assertNotNull( personService );
        List<Person> persons = personService.find( "qiaogh,qiy" );
        Assert.assertNotNull( persons );
        Assert.assertTrue( !persons.isEmpty() );
        Assert.assertEquals( 2, persons.size() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
