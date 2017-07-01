package com.qiaogh;

import java.beans.Introspector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleBeanNameAwareTest {

    @SuppressWarnings( "resource" )
    @Before
    public void before() {
        new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }
    
    @Test
    public void test() {
        SimpleBeanNameAware simpleBeanNameAware = SimpleApplicationContextAware.getBean( SimpleBeanNameAware.class );
        String beanName = Introspector.decapitalize( SimpleBeanNameAware.class.getSimpleName() );
        Assert.assertNotNull( simpleBeanNameAware );
        Assert.assertNotNull( beanName );
        Assert.assertEquals( beanName, simpleBeanNameAware.getBeanName() );
    }
}
