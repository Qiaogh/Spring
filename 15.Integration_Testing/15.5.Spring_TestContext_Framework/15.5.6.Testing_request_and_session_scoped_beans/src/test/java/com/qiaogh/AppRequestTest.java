package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
@WebAppConfiguration
public class AppRequestTest {
    
    @Autowired
    private ApplicationContext cxt;
    
    @Autowired
    private MockHttpServletRequest request;
    
    @Test
    public void test() {
        String id = "1";
        String name = "Qiaogh";
        String age = "27";
        request.setParameter( "id", id );
        request.setParameter( "name", name );
        request.setParameter( "age", age );
        
        Person qiaogh = cxt.getBean( Person.class );
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( id, qiaogh.getId() );
        Assert.assertEquals( name, qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( age ), qiaogh.getAge() );
    }
}
