package com.qiaogh;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import com.qiaogh.config.SimplePropertySource;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ConfigurableApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
        cxt.getEnvironment().getPropertySources().addLast( new SimplePropertySource( "simple.property.source" ) );
    }

    @Test
    public void testSimple() {
        Environment env = cxt.getEnvironment();
        Assert.assertTrue( env.getProperty( "java.version", "null" ).equals( System.getProperty( "java.version" ) ) ); // Java 运行时环境版本
        Assert.assertTrue( env.getProperty( "java.vendor", "null" ).equals( System.getProperty( "java.vendor" ) ) ); // Java 运行时环境供应商
        Assert.assertTrue( env.getProperty( "java.vendor.url", "null" ).equals( System.getProperty( "java.vendor.url" ) ) ); // Java 供应商的 URL
        Assert.assertTrue( env.getProperty( "java.home", "null" ).equals( System.getProperty( "java.home" ) ) ); // Java 安装目录
        Assert.assertTrue( env.getProperty( "java.vm.specification.version", "null" ).equals( System.getProperty( "java.vm.specification.version" ) ) ); // Java 虚拟机规范版本
        Assert.assertTrue( env.getProperty( "java.class.version", "null" ).equals( System.getProperty( "java.class.version" ) ) ); // Java 类格式版本号
        Assert.assertTrue( env.getProperty( "java.class.path", "null" ).equals( System.getProperty( "java.class.path" ) ) ); // Java 类路径
        Assert.assertTrue( env.getProperty( "os.name", "null" ).equals( System.getProperty( "os.name" ) ) ); // 操作系统名称
        Assert.assertTrue( env.getProperty( "os.arch", "null" ).equals( System.getProperty( "os.arch" ) ) ); // 操作系统架构
        Assert.assertTrue( env.getProperty( "os.version", "null" ).equals( System.getProperty( "os.version" ) ) ); // 操作系统般般
        Assert.assertTrue( env.getProperty( "user.home", "null" ).equals( System.getProperty( "user.home" ) ) ); // 用户的主目录
        Assert.assertTrue( env.getProperty( "user.dir", "null" ).equals( System.getProperty( "user.dir" ) ) ); // 用户的当前工作目录
    }
    
    @Test
    public void testCustom() {
        Environment env = cxt.getEnvironment();
        Assert.assertNotNull( env.getProperty( "name" ) );
        Assert.assertEquals( "Qiaogh", env.getProperty( "name" ) );
    }

    @After
    public void after() {
        cxt.close();
    }
}
