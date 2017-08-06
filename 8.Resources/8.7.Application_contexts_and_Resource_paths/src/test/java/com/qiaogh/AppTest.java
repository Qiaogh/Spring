package com.qiaogh;

import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "conf/applicationContext.xml" );
    }

    @Test
    public void test() throws IOException {
        Resource[] resources = cxt.getResources( "conf/*.properties" );
        Assert.assertEquals( 2, resources.length );
        checkAllProperties( resources );
    }
    
    private void checkAllProperties( Resource[] resources ) throws IOException {
        Properties mergedProperties = new Properties();
        for ( Resource resource : resources ) {
            mergedProperties.putAll( PropertiesLoaderUtils.loadProperties( resource ) );
        }
        Assert.assertEquals( "com.mysql.jdbc.Driver", mergedProperties.get( "jdbc.driverClassName" ) );
        Assert.assertEquals( "jdbc:mysql://127.0.0.1:3306/kmmzj?useServerPrepStmts=false&useUnicode=true", mergedProperties.get( "jdbc.url" ) );
        Assert.assertEquals( "root", mergedProperties.get( "jdbc.username" ) );
        Assert.assertEquals( "root", mergedProperties.get( "jdbc.password" ) );
        Assert.assertEquals( "org.hibernate.dialect.MySQLDialect", mergedProperties.get( "hibernate.dialect" ) );
    }

    @After
    public void after() {
        cxt.close();
    }
}
