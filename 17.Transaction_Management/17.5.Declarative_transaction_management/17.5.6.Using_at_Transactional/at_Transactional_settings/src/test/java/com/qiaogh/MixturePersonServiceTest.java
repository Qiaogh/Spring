package com.qiaogh;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.PersonService;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
public class MixturePersonServiceTest {
    
    @Resource( name = "mixturePersonService" )
    public PersonService personService;
    
    @Test
    public void test() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        try {
            personService.save( person );
            Assert.assertTrue( false );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof RollbackForException );
        }
        
        List<Person> persons = personService.query();
        Assert.assertFalse( persons.isEmpty() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
        personService.delete( persons.get( 0 ).getId() );
    }
}
