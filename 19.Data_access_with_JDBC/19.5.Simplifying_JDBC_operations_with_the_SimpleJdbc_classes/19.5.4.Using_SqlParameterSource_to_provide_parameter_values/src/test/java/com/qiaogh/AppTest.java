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
@ContextConfiguration( classes = { AppConfig.class, AppTestConfig.class } )
public class AppTest {

    @Resource( type = PersonService.class )
    private PersonPersistenceSupport personPersistenceSupport;

    @Resource( type = PersonService.class )
    private PersonQuerySupport personQuerySupport;

    @Test
    @Transactional
    public void testCount() {
        Person person = newPerson();
        personPersistenceSupport.save( person );
        int count = personQuerySupport.count();
        Assert.assertEquals( 1, count );
    }
    
    @Test
    @Transactional
    public void testSave() {
        Person person = newPerson();
        Integer id = personPersistenceSupport.save( person );
        Person persistencePerson = personQuerySupport.get( id );
        Assert.assertNotNull( persistencePerson );
        Assert.assertEquals( person.getName(), persistencePerson.getName() );
        Assert.assertEquals( person.getAge(), persistencePerson.getAge() );
    }
    
    @Test
    @Transactional
    public void testDelete() {
        Person person = newPerson();
        personPersistenceSupport.save( person );
        List<Person> persons = personQuerySupport.query();
        Assert.assertFalse( persons.isEmpty() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
        personPersistenceSupport.delete( persons.get( 0 ).getId() );
        persons = personQuerySupport.query();
        Assert.assertTrue( persons.isEmpty() );
    }
    
    @Test
    @Transactional
    public void testUpdate() {
        Person person = newPerson();
        personPersistenceSupport.save( person );
        List<Person> persons = personQuerySupport.query();
        Assert.assertFalse( persons.isEmpty() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
        person = personQuerySupport.get( persons.get( 0 ).getId() );
        person.setName( "QiaoGuoHuan" );
        person.setAge( 16 );
        personPersistenceSupport.update( person );
        persons = personQuerySupport.query();
        Assert.assertFalse( persons.isEmpty() );
        Assert.assertEquals( person.getName(), persons.get( 0 ).getName() );
        Assert.assertEquals( person.getAge(), persons.get( 0 ).getAge() );
    }
    
    private Person newPerson() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        return person;
    }
}
