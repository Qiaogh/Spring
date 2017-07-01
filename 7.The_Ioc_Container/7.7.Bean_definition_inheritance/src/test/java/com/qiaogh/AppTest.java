package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Child;
import com.qiaogh.domain.Parent;

public class AppTest {

    private ClassPathXmlApplicationContext cxt;
    
    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void testQiaotf() {
        Exception exception = null;
        try {
            cxt.getBean( "qiaotf" );
        } catch ( Exception e ) {
            exception = e;
        }
        Assert.assertNotNull( exception );
        Assert.assertTrue( exception instanceof BeanIsAbstractException );
    }
    
    @Test
    public void testQiaogw() {
        Child qiaogw = (Child) cxt.getBean( "qiaogw" );
        Assert.assertNotNull( qiaogw );
        Assert.assertEquals( "乔", qiaogw.getFirstName() );
        Assert.assertEquals( "国旺", qiaogw.getLastName() );
    }

    @Test
    public void testQiaogh() {
        Parent qiaogh = (Parent) cxt.getBean( "qiaogh" );
        Assert.assertNotNull( qiaogh );
        Assert.assertEquals( "乔", qiaogh.getFirstName() );
        Assert.assertEquals( "国欢", qiaogh.getLastName() );
    }
}
