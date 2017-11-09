package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.domain.Person;
import com.qiaogh.exception.NoRollbackForException;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.ExceptionPersonService;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:applicationContext.xml" )
public class AppTest {
    
    @Autowired
    private ExceptionPersonService personService;
    
    @Test
    public void testRollback() {
        Person person = createPersistencePerson();
        person.setName( "QiaoGuoHuan" );
        person.setAge( 15 );
        try {
            personService.exUpdate( person, new RollbackForException() );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof RollbackForException );
        }
        person = personService.get( person.getId() );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), person.getAge() );
        personService.delete( person.getId() );
    }
    
    @Test
    public void testNoRollback() {
        Person person = createPersistencePerson();
        person.setName( "QiaoGuoHuan" );
        person.setAge( 15 );
        try {
            personService.exUpdate( person, new NoRollbackForException() );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof NoRollbackForException );
        }
        person = personService.get( person.getId() );
        Assert.assertEquals( "QiaoGuoHuan", person.getName() );
        Assert.assertEquals( Integer.valueOf( 15 ), person.getAge() );
        personService.delete( person.getId() );
    }
    
    private Person createPersistencePerson() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        personService.save( person );
        return personService.query().get( 0 );
    }
}
