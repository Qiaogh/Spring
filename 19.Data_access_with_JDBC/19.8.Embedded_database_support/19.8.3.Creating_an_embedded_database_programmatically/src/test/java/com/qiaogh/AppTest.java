package com.qiaogh;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private PersonPersistenceSupport persistenceSupport;

    @Resource( type = PersonService.class )
    private PersonQuerySupport querySupport;

    @Test
    @Transactional
    public void testCount() throws SerialException, SQLException {
        Person person = newPerson();
        persistenceSupport.save( person );
        int count = querySupport.count();
        Assert.assertEquals( 1, count );
    }
    
    @Test
    @Transactional
    public void testSave() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = persistenceSupport.save( person );
        Person persistencePerson = querySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
    }
    
    @Test( expected = EmptyResultDataAccessException.class )
    @Transactional
    public void testDelete() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = persistenceSupport.save( person );
        Person persistencePerson = querySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
        persistenceSupport.delete( id );
        querySupport.get( id );
    }
    
    @Test
    @Transactional
    public void testUpdate() throws SerialException, SQLException {
        Person person = newPerson();
        Integer id = persistenceSupport.save( person );
        Person persistencePerson = querySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertEquals( person.getData(), persistencePerson.getData() );
        persistencePerson.setName( "QiaoGuoHuan" );
        persistencePerson.setAge( 16 );
        persistencePerson.setData( "BBBB" );
        persistenceSupport.update( persistencePerson );
        persistencePerson = querySupport.get( id );
        Assert.assertTrue( persistencePerson != null );
        Assert.assertNotEquals( person.getName(), persistencePerson.getName() );
        Assert.assertNotEquals( person.getAge(), persistencePerson.getAge() );
        Assert.assertNotEquals( person.getData(), persistencePerson.getData() );
    }
    
    @Test
    @Transactional
    public void testQuery() throws SerialException, SQLException {
        List<Integer> ids = new ArrayList<Integer>( 3 );
        ids.add( persistenceSupport.save( newPerson() ) );
        ids.add( persistenceSupport.save( newPerson() ) );
        ids.add( persistenceSupport.save( newPerson() ) );
        List<Person> persons = querySupport.query( ids.toArray( new Integer[ ids.size() ] ) );
        Assert.assertEquals( ids.size(), persons.size() );
    }
    
    private Person newPerson() throws SerialException, SQLException {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        person.setData( "AAA" );
        return person;
    }
}
