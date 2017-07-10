package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Son;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClassPathXmlApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void testAnnotation() {
        Man husband = cxt.getBean( Man.class );
        Women wife = cxt.getBean( Women.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertSame( wife, husband.getWife() );
        Assert.assertSame( husband, wife.getHusband() );
        Assert.assertSame( wife.getName(), husband.getWifeName() );
    }
    
    @Test
    public void testXml() {
        Man husband = cxt.getBean( Man.class );
        Women wife = cxt.getBean( Women.class );
        Son qiaoxl = cxt.getBean( Son.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertNotNull( qiaoxl );
        Assert.assertSame( husband, qiaoxl.getFather() );
        Assert.assertSame( husband.getName(), qiaoxl.getFatherName() );
        Assert.assertSame( wife, qiaoxl.getMother() );
        Assert.assertSame( wife.getName(), qiaoxl.getMotherName() );
    }
    
    @After
    public void after() {
        cxt.destroy();
    }
}
