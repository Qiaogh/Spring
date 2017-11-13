package com.qiaogh;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;
import com.qiaogh.exception.RollbackForException;
import com.qiaogh.service.PersonService;

@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
public class TransactionPersonServiceTest {

    @Resource( name = "transactionPersonService" )
    private PersonService personService;
    
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
