package com.qiaogh;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.qiaogh.domain.Person;
import com.qiaogh.service.PersonService;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:spring-basic.xml" )
public class AppTest {
    
    @Autowired
    private PersonService personService;
    
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
}
