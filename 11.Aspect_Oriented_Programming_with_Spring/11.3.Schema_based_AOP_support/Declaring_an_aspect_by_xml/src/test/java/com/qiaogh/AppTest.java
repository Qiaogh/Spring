package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.aspect.PersonServiceAspect;

public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
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
