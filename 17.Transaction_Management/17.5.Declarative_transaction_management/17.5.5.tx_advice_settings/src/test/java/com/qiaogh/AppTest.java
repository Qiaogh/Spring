package com.qiaogh;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.CannotSaveException;
import com.qiaogh.service.CannotSavePersonService;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:applicationContext.xml" )
public class AppTest {
    
    @Autowired
    public CannotSavePersonService personService;
    
    @Test
    public void test() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        try {
            personService.exSave( person );
            Assert.assertTrue( false );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof CannotSaveException );
        }
        
        List<Person> persons = personService.query();
        Assert.assertTrue( !persons.isEmpty() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
        personService.delete( persons.get( 0 ).getId() );
    }
}
