package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
    public void testAdvised() {
        Advised advised = cxt.getBean( "personService", Advised.class );
        Advisor personServiceBeforeGetAdvisor = cxt.getBean( "personServiceBeforeGetAdvisor", Advisor.class );
        Advisor personServiceAfterGetReturningAdvisor = cxt.getBean( "personServiceAfterGetReturningAdvisor", Advisor.class );
        Assert.assertTrue( advised instanceof PersonService );
        Advisor[] advisors = advised.getAdvisors();
        Assert.assertFalse( advisors.length == 0 );
        Assert.assertEquals( personServiceBeforeGetAdvisor, advisors[0] );
        Assert.assertEquals( personServiceAfterGetReturningAdvisor, advisors[1] );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
