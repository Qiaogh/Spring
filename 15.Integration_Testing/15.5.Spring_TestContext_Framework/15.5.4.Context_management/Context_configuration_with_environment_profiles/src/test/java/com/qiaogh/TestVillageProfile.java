package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.qiaogh.domain.Person;
import com.qiaogh.resovler.SimpleActiveProfilesResolver;

@ActiveProfiles( resolver = SimpleActiveProfilesResolver.class )
public class TestVillageProfile extends TestConfig {

    @Autowired
    private Person qiaogh;
    
    @Test
    public void test() {
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
        Assert.assertEquals( "village", qiaogh.getStatus() );
    }
}
