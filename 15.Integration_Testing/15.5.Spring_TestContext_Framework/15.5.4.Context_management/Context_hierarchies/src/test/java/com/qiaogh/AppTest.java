package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.config.TestConfig;
import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextHierarchy({
    @ContextConfiguration( classes = AppConfig.class ),
    @ContextConfiguration( classes = TestConfig.class )
})
public class AppTest {
    
    @Autowired
    private ApplicationContext cxt;
    
    @Test
    public void test() {
        Assert.assertNotNull( cxt );
        Assert.assertNotNull( cxt.getParent() );
        Person childPerson = cxt.getBean( Person.class );
        Assert.assertNotNull( childPerson );
        Person rootPerson = cxt.getParent().getBean( Person.class );
        Assert.assertNotNull( rootPerson );
        Assert.assertNotSame( childPerson, rootPerson );
        Assert.assertEquals( childPerson.getId(), rootPerson.getId() );
        Assert.assertEquals( childPerson.getName(), rootPerson.getName() );
        Assert.assertEquals( childPerson.getAge(), rootPerson.getAge() );
    }
}
