package com.qiaogh;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.domain.Person;
import com.qiaogh.service.SimpleExceptionPersonService;

@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:applicationContext.xml" )
public class AppTest extends TestCase {
    
    @Autowired
    private SimpleExceptionPersonService personService;
    
    @Test
    @Transactional
    public void testSave() {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        personService.save( person );
        List<Person> persons = personService.query();
        Assert.assertFalse( persons.isEmpty() );
    }
    
    @Test
    @Transactional
    public void testUpdate() {
        testSave();
        List<Person> persons = personService.query();
        Person person = persons.get( 0 );
        person.setName( "QiaoGuoHuan" );
        person.setAge( 15 );
        personService.update( person );
        person = personService.get( person.getId() );
        Assert.assertEquals( "QiaoGuoHuan", person.getName() );
        Assert.assertEquals( Integer.valueOf( 15 ), person.getAge() );
    }
    
    @Test
    @Transactional
    public void testUpdateException() {
        try {
            personService.update( new Person() );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof IllegalArgumentException );
        }
    }
    
    @Test
    public void testExUpdate() {
        testSave();
        List<Person> persons = personService.query();
        Person person = persons.get( 0 );
        person.setName( "QiaoGuoHuan" );
        person.setAge( 15 );
        try {
            personService.exUpdate( person );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof RuntimeException );
        }
        person = personService.get( person.getId() );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), person.getAge() );
        personService.delete( person.getId() );
    }

    @Test
    @Transactional
    public void testDelete() {
        testSave();
        Person person = personService.query().get( 0 );
        personService.delete( person.getId() );
        List<Person> persons = personService.query();
        Assert.assertTrue( persons.isEmpty() );
    }
    
    @Test
    @Transactional
    public void testDeleteException() {
        try {
            personService.delete( 1 );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof IllegalArgumentException );
        }
    }
    
    @Test
    public void testExDelete() {
        testSave();
        Person person = personService.query().get( 0 );
        try {
            personService.exDelete( person.getId() );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof RuntimeException );
        }
        List<Person> persons = personService.query();
        Assert.assertFalse( persons.isEmpty() );
        personService.delete( persons.get( 0 ).getId() );
    }
}
