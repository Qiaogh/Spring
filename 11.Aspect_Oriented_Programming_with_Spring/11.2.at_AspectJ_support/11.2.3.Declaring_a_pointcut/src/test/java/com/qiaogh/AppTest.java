package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.qiaogh.aspect.PersonServiceAspect;
import com.qiaogh.config.AppConfig;

public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
    }

    @Test
    public void test() {
        PersonServiceAspect personServiceAspect = cxt.getBean( PersonServiceAspect.class );
        Assert.assertNotNull( personServiceAspect );
    }

    @After
    public void after() {
        cxt.close();
    }
}
