package com.qiaogh;

import com.qiaogh.domain.Children;
import com.qiaogh.domain.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {

    private ClassPathXmlApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void testConstructorInjection() {
        Person constructorInjection = (Person) cxt.getBean( "constructorInjection" );
        Assert.assertNotNull( constructorInjection );
        Assert.assertTrue( Integer.valueOf( 1 ).equals( constructorInjection.getId() ) );
        Assert.assertTrue( "Qiaogh".equals( constructorInjection.getName() ) );
        Assert.assertTrue( Integer.valueOf( 26 ).equals( constructorInjection.getAge() ) );
    }

    @Test
    public void testSetterInjection() {
        Person setterInjection = (Person) cxt.getBean( "setterInjection" );
        Assert.assertNotNull( setterInjection );
        Assert.assertTrue( Integer.valueOf( 2 ).equals( setterInjection.getId() ) );
        Assert.assertTrue( "Qiy".equals( setterInjection.getName() ) );
        Assert.assertTrue( Integer.valueOf( 30 ).equals( setterInjection.getAge() ) );
    }

    @Test
    public void testFactoryInjection() {
        Person father = (Person) cxt.getBean( "father" );
        Children factoryInjection = (Children) cxt.getBean( "factoryInjection" );
        Assert.assertNotNull( father );
        Assert.assertNotNull( factoryInjection );
        Assert.assertTrue( Integer.valueOf( 3 ).equals( factoryInjection.getId() ) );
        Assert.assertTrue( "Qiaohy".equals( factoryInjection.getName() ) );
        Assert.assertTrue( Integer.valueOf( 2 ).equals( factoryInjection.getAge() ) );
        Assert.assertTrue( father.equals( factoryInjection.getFather() ) );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
