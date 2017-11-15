package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.service.PersonService;

/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( "classpath:applicationContext.xml" )
public class AppTest {
    
    @Autowired
    private PersonService personService;
    
    @Test
    public void test() {
        Assert.assertNotNull( personService );
    }
}
