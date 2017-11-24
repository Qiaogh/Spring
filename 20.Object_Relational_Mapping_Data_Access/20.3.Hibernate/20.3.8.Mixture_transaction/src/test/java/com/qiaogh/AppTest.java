package com.qiaogh;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.rowset.serial.SerialException;

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
    private PersonPersistenceSupport persistenceSupport;

    @Test
    @Transactional
    public void testSave() throws SerialException, SQLException {
        Person person = newPerson();
        persistenceSupport.save( person );
    }
    
    private Person newPerson() throws SerialException, SQLException {
        Person person = new Person();
        person.setName( "Qiaogh" );
        person.setAge( 26 );
        person.setData( "AAA" );
        return person;
    }
}
