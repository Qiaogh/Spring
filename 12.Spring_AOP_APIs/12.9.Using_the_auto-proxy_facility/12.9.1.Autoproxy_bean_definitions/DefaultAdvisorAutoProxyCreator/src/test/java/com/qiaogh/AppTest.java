package com.qiaogh;

import java.beans.Introspector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.Advised;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.aop.BeforeGetMethodAdvice;
import com.qiaogh.domain.Family;
import com.qiaogh.domain.Person;
import com.qiaogh.service.FamilyService;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.FamilyServiceImpl;
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
    public void testPersonServiceBasicApi() {
        PersonService personService = new PersonServiceImpl();
        Person qiaogh = personService.get( "1" );
        assertIsQiaogh( qiaogh );
    }
    
    @Test
    public void testFamilyServiceBasicApi() {
        FamilyService familiyService = new FamilyServiceImpl();
        Family qiaogh = familiyService.get( "1" );
        assertIsQiao( qiaogh );
    }
    
    @Test
    public void testPersonServiceAutoProxyApi() {
        String beanName = Introspector.decapitalize( PersonService.class.getSimpleName() );
        Assert.assertFalse( BeforeGetMethodAdvice.CACHED_SERVICE.containsKey( beanName ) );
        
        PersonService personService = cxt.getBean( PersonService.class );
        Person qiaogh = personService.get( "1" );
        assertIsQiaogh( qiaogh );

        Assert.assertTrue( BeforeGetMethodAdvice.CACHED_SERVICE.containsKey( beanName ) );
        Assert.assertTrue( personService instanceof Advised );
    }
    
    @Test
    public void testFamilyServiceAutoProxyApi() {
        String beanName = Introspector.decapitalize( FamilyService.class.getSimpleName() );
        Assert.assertFalse( BeforeGetMethodAdvice.CACHED_SERVICE.containsKey( beanName ) );
        
        FamilyService familyService = cxt.getBean( FamilyService.class );
        Family qiao = familyService.get( "1" );
        assertIsQiao( qiao );

        Assert.assertTrue( BeforeGetMethodAdvice.CACHED_SERVICE.containsKey( beanName ) );
        Assert.assertTrue( familyService instanceof Advised );
    } 
    
    private void assertIsQiaogh( Person qiaogh ) {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
    }
    
    private void assertIsQiao( Family family ) {
        Assert.assertNotNull( family );
        Assert.assertEquals( "1", family.getId() );
        Assert.assertEquals( "Qiao", family.getName() );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
