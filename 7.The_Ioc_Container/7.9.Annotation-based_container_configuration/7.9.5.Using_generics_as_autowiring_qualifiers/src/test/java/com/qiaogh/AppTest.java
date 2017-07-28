package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void simpleTest() {
        Man husband = cxt.getBean( Man.class );
        Women wife = cxt.getBean( Women.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( husband, wife.getHusband() );
    }
    
    @Test
    public void testWorld() {
        World world = cxt.getBean( World.class );
        Assert.assertNotNull( world );
        Assert.assertTrue( !world.getMans().isEmpty() );
        Assert.assertTrue( !world.getWomens().isEmpty() );
    }

    @After
    public void after() {
        cxt.close();
    }
}
