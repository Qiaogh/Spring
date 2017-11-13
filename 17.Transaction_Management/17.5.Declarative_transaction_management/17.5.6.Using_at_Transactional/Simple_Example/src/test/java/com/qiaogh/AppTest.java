package com.qiaogh;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.PersonService;



/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:applicationContext.xml" )
public class AppTest {
    
    @Resource( name = "transactionPersonService" )
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
        Assert.assertTrue( persons.isEmpty() );
    }
}
