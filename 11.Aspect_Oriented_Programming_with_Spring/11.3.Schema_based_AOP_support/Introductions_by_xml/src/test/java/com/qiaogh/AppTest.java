package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Person;
import com.qiaogh.introductions.PersonServiceIntroduction;
import com.qiaogh.service.PersonService;

public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        PersonServiceIntroduction personService = (PersonServiceIntroduction) cxt.getBean( PersonService.SERVICEKEY );
        Assert.assertNotNull( personService );
        Assert.assertFalse( personService.validate( null ) );
        Assert.assertFalse( personService.validate( new Person( "", "", null ) ) );
        Assert.assertFalse( personService.validate( new Person( "1", "", null ) ) );
        Assert.assertFalse( personService.validate( new Person( "1", "Qiaogh", null ) ) );
        Assert.assertFalse( personService.validate( new Person( "", "Qiaogh", null ) ) );
        Assert.assertFalse( personService.validate( new Person( "", "Qiaogh", 26 ) ) );
        Assert.assertFalse( personService.validate( new Person( "", "", 26 ) ) );
        Assert.assertFalse( personService.validate( new Person( "1", "", 26 ) ) );
        Assert.assertTrue( personService.validate( new Person( "1", "Qiaogh", 26 ) ) );
        Person person = new Person( "1", "Qiaogh", 26 );
        personService.save( person );
    }

    @After
    public void after() {
        cxt.close();
    }
}
