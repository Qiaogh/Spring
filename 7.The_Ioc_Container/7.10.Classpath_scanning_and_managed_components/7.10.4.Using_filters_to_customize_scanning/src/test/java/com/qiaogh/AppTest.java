package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Daughter;
import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void testInclude() {
        Man husband = cxt.getBean( Man.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( husband.getId() );
        Assert.assertNotNull( husband.getName() );
        Assert.assertNotNull( husband.getAge() );
    }
    
    @Test
    public void testExclude() {
        try {
            cxt.getBean( Women.class );
            throw new RuntimeException();
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof NoSuchBeanDefinitionException );
        }
    }
    
    @Test
    public void testCustomFilter() {
        try {
            cxt.getBean( Daughter.class );
            throw new RuntimeException();
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof NoSuchBeanDefinitionException );
        }
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
