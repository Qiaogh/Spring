package com.qiaogh;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.dao.EmptyResultDataAccessException;
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
@ContextConfiguration( classes = { AppConfig.class, AppTestConfig.class } )
public class AppTest {

    @Resource( type = PersonService.class )
    private PersonPersistenceSupport personPersistenceSupport;

    @Resource( type = PersonService.class )
    private PersonQuerySupport personQuerySupport;

    @Test
    @Transactional
    public void testCount() throws SerialException, SQLException {
        Person person = newPerson();
        personPersistenceSupport.save( person );
        int count = personQuerySupport.count();
        Assert.assertEquals( 1, count );
    }
    
    @Test
    @Transactional
    public void testSave() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = personPersistenceSupport.save( person );
        Person persistencePerson = personQuerySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
    }
    
    @Test( expected = EmptyResultDataAccessException.class )
    @Transactional
    public void testDelete() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = personPersistenceSupport.save( person );
        Person persistencePerson = personQuerySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
        personPersistenceSupport.delete( id );
        personQuerySupport.get( id );
    }
    
    @Test
    @Transactional
    public void testUpdate() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = personPersistenceSupport.save( person );
        Person persistencePerson = personQuerySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
        persistencePerson.setName( "QiaoGuoHuan" );
        persistencePerson.setAge( 16 );
        persistencePerson.setData( "BBBB" );
        personPersistenceSupport.update( persistencePerson );
        persistencePerson = personQuerySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertNotEquals( person.getName(), persistencePerson.getName() );
        Assert.assertNotEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertNotEquals( person.getData(), persistencePerson.getData() );
    }
    
    private Person newPerson() throws SerialException, SQLException {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        person.setData( "AAA" );
        return person;
    }
}
