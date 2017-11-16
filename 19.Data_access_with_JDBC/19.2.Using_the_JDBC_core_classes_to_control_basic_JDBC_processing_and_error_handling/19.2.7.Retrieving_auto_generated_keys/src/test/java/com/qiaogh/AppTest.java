package com.qiaogh;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.AppTestConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = { AppConfig.class, AppTestConfig.class })
public class AppTest {
    
    @Resource( type = PersonService.class )
    private PersonPersistenceSupport persistenceSupport;
    
    @Resource( type = PersonService.class )
    private PersonQuerySupport querySupport;
    
    @Test
    @Transactional
    public void test() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        Integer id = persistenceSupport.save( person );
        Assert.assertNotNull( id );
        
        List<Person> persons = querySupport.query();
        Assert.assertFalse( persons.isEmpty() );
        Assert.assertEquals( id, persons.get( 0 ).getId() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
    }
}
