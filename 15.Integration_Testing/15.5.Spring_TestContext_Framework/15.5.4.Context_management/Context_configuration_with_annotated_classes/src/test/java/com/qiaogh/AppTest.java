package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;

@RunWith( SpringRunner.class )
public class AppTest {
    
    @Configuration
    @Import( AppConfig.class )
    static class Config {
        
    }
    
    private Person person;
    
    @Test
    public void test() {
        Assert.assertNotNull( person );
        Assert.assertEquals( "1", person.getId() );
        Assert.assertEquals( "Qiaogh", person.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), person.getAge() );
    }

    public Person getPerson() {
        return person;
    }

    @Autowired
    public void setPerson( Person person ) {
        this.person = person;
    }
}
