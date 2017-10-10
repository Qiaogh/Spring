package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.qiaogh.domain.Person;

/**
 * Unit test for simple App.
 */
@ActiveProfiles( "city" )
public class TestCityProfile extends TestConfig {
    
    @Autowired
    private Person qiaogh;
    
    @Test
    public void test() {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
        Assert.assertEquals( "city", qiaogh.getStatus() );
    }
}
