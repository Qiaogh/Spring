package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.config.DevelopmentAppConfig;
import com.qiaogh.config.ProduceAppConfig;
import com.qiaogh.domain.Man;
import com.qiaogh.domain.Women;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ApplicationContext cxt;

    @Before
    public void before() {
        if ( "developer".equals( System.getenv( "spring.profiles.active" ) ) ) {
            try {
                cxt = new AnnotationConfigApplicationContext( DevelopmentAppConfig.class, ProduceAppConfig.class );
            } catch ( Exception e ) {
                Assert.assertTrue( e instanceof NoSuchBeanDefinitionException );
            }
        }
    }

    @Test
    public void test() {
        if ( "produce".equals( System.getenv( "spring.profiles.active" ) ) ) {
            Man husband = cxt.getBean( Man.class );
            Women wife = cxt.getBean( Women.class );
            Assert.assertNotNull( husband );
            Assert.assertNotNull( wife );
            Assert.assertEquals( wife, husband.getWife() );
            Assert.assertEquals( husband, wife.getHusband() );
        }
    }

    @After
    public void after() {
        if ( cxt instanceof ConfigurableApplicationContext ) {
            ( (ConfigurableApplicationContext) cxt ).close();
        }
    }
}
