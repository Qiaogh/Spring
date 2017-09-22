package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.aop.PersonServiceBeforeGetAdvice;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;



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
    public void testBasicApi() {
        PersonService personService = new PersonServiceImpl();
        Person qiaogh = personService.get( "1" );
        assertIsQiaogh( qiaogh );
    }
    
    @Test
    public void testPointcutApi() {
        PersonService personService = cxt.getBean( "personService", PersonService.class );
        Assert.assertNotNull( personService );
        Person qiaogh = personService.get( "1" );
        Assert.assertTrue( PersonServiceBeforeGetAdvice.INVOKED );
        assertIsQiaogh( qiaogh );
    }
    
    private void assertIsQiaogh( Person qiaogh ) {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
