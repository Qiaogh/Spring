package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

import com.qiaogh.config.AppConfig;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new AnnotationConfigApplicationContext( AppConfig.class );
    }

    @Test
    public void test() {
        Environment env = cxt.getEnvironment();
        Assert.assertEquals( "com.mysql.jdbc.Driver", env.getProperty( "jdbc.driverClassName" ) );
        Assert.assertEquals( "jdbc:mysql://127.0.0.1:3306/kmmzj?useServerPrepStmts=false&useUnicode=true", env.getProperty( "jdbc.url" ) );
        Assert.assertEquals( "root", env.getProperty( "jdbc.username" ) );
        Assert.assertEquals( "root", env.getProperty( "jdbc.password" ) );
    }

    @After
    public void after() {
        cxt.close();
    }
}
