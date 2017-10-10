package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.qiaogh.config.AppConfig;
import com.qiaogh.domain.Person;


/**
 * Unit test for simple App.
 */
@RunWith( SpringRunner.class )
@ContextConfiguration( classes = AppConfig.class )
public class AppPropertySourceTest {
    
    private Person qiaogh;

    @Test
    public void test() {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
        Assert.assertEquals( "Application", qiaogh.getFrom() );
    }
    
    public Person getQiaogh() {
        return qiaogh;
    }

    @Autowired
    public void setQiaogh( Person qiaogh ) {
        this.qiaogh = qiaogh;
    }
}
