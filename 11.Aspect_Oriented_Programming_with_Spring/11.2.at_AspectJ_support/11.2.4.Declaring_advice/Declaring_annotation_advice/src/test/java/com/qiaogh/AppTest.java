package com.qiaogh;

import java.beans.Introspector;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.exception.CannotFindPersonException;
import com.qiaogh.service.PersonService;
import com.qiaogh.service.impl.PersonServiceImpl;

public class AppTest {

    private ConfigurableApplicationContext cxt;
    private Service service;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
        service = PersonServiceImpl.class.getAnnotation( Service.class );
        Assert.assertEquals( Introspector.decapitalize( PersonService.class.getSimpleName() ), service.value() );
    }

    @Test
    public void testSimple() {
        PersonService personService = cxt.getBean( PersonService.class );
        Assert.assertNotNull( personService );
        
        Person qiaogh = personService.get( "1" );
        Assert.assertFalse( PersonServiceAspect.INVOKED_ADVICES.isEmpty() );
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.containsKey( PersonServiceAspect.BEFORE_GET ) );
        Assert.assertEquals( service, PersonServiceAspect.INVOKED_ADVICES.get( PersonServiceAspect.BEFORE_GET ) );
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.containsKey( PersonServiceAspect.AFTER_GET ) );
        Assert.assertEquals( service, PersonServiceAspect.INVOKED_ADVICES.get( PersonServiceAspect.AFTER_GET ) );
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.containsKey( PersonServiceAspect.AFTER_GET_RETURNING ) );
        Assert.assertEquals( service, PersonServiceAspect.INVOKED_ADVICES.get( PersonServiceAspect.AFTER_GET_RETURNING ) );
        
        Assert.assertSame( qiaogh, PersonServiceAspect.LOADED_PERSONS.get( 0 ) );
    }
    
    @Test
    public void testAfterThrowingWithNullElement() {
        PersonService personService = cxt.getBean( PersonService.class );
        Assert.assertNotNull( personService );
        
        try {
            Person some = personService.get( "3" );
            Assert.assertNull( some );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof IllegalArgumentException );
            Assert.assertSame( e, PersonServiceAspect.THORWED_EXCEPTIONS.get( 0 ) );
        }
    }
    
    @Test
    public void testAfterThrowingWithCannotFindPerson() {
        PersonService personService = cxt.getBean( PersonService.class );
        Assert.assertNotNull( personService );
        
        try {
            Person some = personService.get( "4" );
            Assert.assertNull( some );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof CannotFindPersonException );
            Assert.assertSame( e, PersonServiceAspect.THORWED_EXCEPTIONS.get( 1 ) );
        }
    }
    
    @Test
    public void testAroundUpdate() {
        String personId = "3";
        PersonService personService = cxt.getBean( PersonService.class );
        Assert.assertNotNull( personService );
        
        Person person = new Person( personId, "SomeName", new Random().nextInt( 30 ) );
        personService.update( person );
        Assert.assertTrue( PersonServiceAspect.INVOKED_ADVICES.containsKey( PersonServiceAspect.AROUND_UPDATE ) );
        Assert.assertEquals( service, PersonServiceAspect.INVOKED_ADVICES.get( PersonServiceAspect.AROUND_UPDATE ) );
        Assert.assertEquals( person, PersonServiceAspect.UPDATED_PERSONS.get( 0 ) );
    }

    @After
    public void after() {
        cxt.close();
    }
}
