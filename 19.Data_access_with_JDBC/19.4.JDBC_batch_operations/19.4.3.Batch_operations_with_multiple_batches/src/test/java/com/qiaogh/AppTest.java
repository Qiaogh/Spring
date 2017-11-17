package com.qiaogh;

import java.util.ArrayList;
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
    
    private static final int BATCH_SIZE = 32;
    
    @Resource( type = PersonService.class )
    private PersonPersistenceSupport persistenceSupport;
    @Resource( type = PersonService.class )
    private PersonQuerySupport querySupport;
    
    @Test
    @Transactional
    public void test() {
        List<Person> persons = createBatchPerson( BATCH_SIZE );
        persistenceSupport.save( persons );
        
        List<Person> persistencePersons = querySupport.query();
        Assert.assertEquals( persons.size(), persistencePersons.size() );
    }
    
    private List<Person> createBatchPerson( int batchSize ) {
        List<Person> persons = new ArrayList<Person>( batchSize );
        for ( int i = 0; i < batchSize; i++ ) {
            Person person = new Person();
            person.setName( "Qiaogh" );
            person.setAge( 26 );
            persons.add( person );
        }
        return persons;
    }
}
