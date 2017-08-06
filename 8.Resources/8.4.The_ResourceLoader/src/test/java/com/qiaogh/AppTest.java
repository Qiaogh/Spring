package com.qiaogh;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.PropertiesLoaderUtils;


/**
 * Unit test for simple App.
 */
public class AppTest {
    
    private ResourceLoader resourceLoader;
    
    @Before
    public void before() {
        resourceLoader = new ClassPathXmlApplicationContext();
    }
    
    @Test
    public void testDefault() throws IOException {
        Resource resource = resourceLoader.getResource( "jdbc.properties" );
        Properties props = PropertiesLoaderUtils.loadProperties( resource );
        Assert.assertEquals( "com.mysql.jdbc.Driver", props.get( "jdbc.driverClassName" ) );
        Assert.assertEquals( "jdbc:mysql://127.0.0.1:3306/kmmzj?useServerPrepStmts=false&useUnicode=true", props.get( "jdbc.url" ) );
        Assert.assertEquals( "root", props.get( "jdbc.username" ) );
        Assert.assertEquals( "root", props.get( "jdbc.password" ) );
    }
    
    @Test
    public void testSpecificProtocol() throws IOException {
        Resource resource = resourceLoader.getResource( "classpath:jdbc.properties" );
        Properties props = PropertiesLoaderUtils.loadProperties( resource );
        Assert.assertEquals( "com.mysql.jdbc.Driver", props.get( "jdbc.driverClassName" ) );
        Assert.assertEquals( "jdbc:mysql://127.0.0.1:3306/kmmzj?useServerPrepStmts=false&useUnicode=true", props.get( "jdbc.url" ) );
        Assert.assertEquals( "root", props.get( "jdbc.username" ) );
        Assert.assertEquals( "root", props.get( "jdbc.password" ) );
    }
}
