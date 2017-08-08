package com.qiaogh;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void test() {
        BeanWrapper wrapper = new BeanWrapperImpl( new Man() );
        wrapper.setPropertyValue( "id", "1" );
        wrapper.setPropertyValue( "name", "Qiaogh" );
        wrapper.setPropertyValue( "age", 26 );
        wrapper.setPropertyValue( "wife", new Women() );
        wrapper.setPropertyValue( "wife.id", "2" );
        wrapper.setPropertyValue( "wife.name", "Qiy" );
        wrapper.setPropertyValue( "wife.age", "24" );
        wrapper.setPropertyValue( "wife.husband", wrapper.getWrappedInstance() );
        
        Man qiaogh = (Man) wrapper.getWrappedInstance();
        Women qiy = (Women) wrapper.getPropertyValue( "wife" );
        Assert.assertNotNull( qiaogh );
        Assert.assertNotNull( qiy );
        Assert.assertEquals( "1", qiaogh.getId() );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( Integer.valueOf( 26 ), qiaogh.getAge() );
        Assert.assertSame( qiy, qiaogh.getWife() );
        
        Assert.assertEquals( "2", qiy.getId() );
        Assert.assertEquals( "Qiy", qiy.getName() );
        Assert.assertEquals( Integer.valueOf( 24 ), qiy.getAge() );
        Assert.assertSame( qiaogh, qiy.getHusband() );
    }
}
