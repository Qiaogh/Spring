package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
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
    public void testBigFamily() {
        cxt.getEnvironment().setActiveProfiles( "gh", "qiy", "gw", "zn" );
        
        try {
            cxt.refresh();
            throw new RuntimeException();
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof BeanCreationException );
            Assert.assertTrue( e.getCause() instanceof NoUniqueBeanDefinitionException );
        }
    }

    @Test
    public void testGhFamily() {
        cxt.getEnvironment().setActiveProfiles( "gh", "qiy" );
        cxt.refresh();

        Man qiaogh = cxt.getBean( Man.class );
        Women qiy = cxt.getBean( Women.class );
        Assert.assertNotNull( qiaogh );
        Assert.assertNotNull( qiy );
        Assert.assertEquals( "Qiaogh", qiaogh.getName() );
        Assert.assertEquals( "Qiy", qiy.getName() );
        Assert.assertEquals( qiy, qiaogh.getWife() );
        Assert.assertEquals( qiaogh, qiy.getHusband() );
    }

    @Test
    public void testGwFamily() {
        cxt.getEnvironment().setActiveProfiles( "gw", "zn" );
        cxt.refresh();

        Man qiaogw = cxt.getBean( Man.class );
        Women zn = cxt.getBean( Women.class );
        Assert.assertNotNull( qiaogw );
        Assert.assertNotNull( zn );
        Assert.assertEquals( "Qiaogw", qiaogw.getName() );
        Assert.assertEquals( "Zn", zn.getName() );
        Assert.assertEquals( zn, qiaogw.getWife() );
        Assert.assertEquals( qiaogw, zn.getHusband() );
    }
    
    @After
    public void after() {
        cxt.close();
    }
}
