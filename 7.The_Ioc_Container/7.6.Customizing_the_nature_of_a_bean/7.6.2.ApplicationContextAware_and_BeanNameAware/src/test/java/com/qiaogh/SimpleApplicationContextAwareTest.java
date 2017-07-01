package com.qiaogh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleApplicationContextAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        try {
            SimpleApplicationContextAware.getBean( Object.class );
        } catch ( Exception e ) {
            Assert.assertTrue( e instanceof NoUniqueBeanDefinitionException );
        }
    }
}
