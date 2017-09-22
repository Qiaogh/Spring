package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.aop.PersonServiceAfterGetReturningAdvice;
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
    public void testAfterReturningAdvice() {
        String id = "1";
        Assert.assertTrue( PersonServiceAfterGetReturningAdvice.LOADED_PERSONS.isEmpty() );
        PersonService personService = cxt.getBean( PersonService.SERVICEKEY, PersonService.class );
        
        Person qiaogh = personService.get( id );
        Assert.assertNotNull( qiaogh );
        assertIsQiaogh( qiaogh );
        Assert.assertFalse( PersonServiceAfterGetReturningAdvice.LOADED_PERSONS.isEmpty() );
        Assert.assertEquals( PersonServiceAfterGetReturningAdvice.LOADED_PERSONS.get( id ), qiaogh );
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
