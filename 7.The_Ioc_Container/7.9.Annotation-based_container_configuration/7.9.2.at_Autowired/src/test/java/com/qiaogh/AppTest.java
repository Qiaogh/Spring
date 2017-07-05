package com.qiaogh;

import java.beans.Introspector;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.qiaogh.domain.Husband;
import com.qiaogh.domain.Wife;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private ClassPathXmlApplicationContext cxt;

    @Before
    public void before() {
        cxt = new ClassPathXmlApplicationContext( "applicationContext.xml" );
    }

    @Test
    public void test() {
        Husband husband = cxt.getBean( Husband.class );
        Wife wife = cxt.getBean( Wife.class );
        Assert.assertNotNull( husband );
        Assert.assertNotNull( wife );
        Assert.assertEquals( wife, husband.getWife() );
        Assert.assertEquals( husband, wife.getHusband() );
        Assert.assertNotNull( husband.getWifes() );
        Assert.assertEquals( 1, husband.getWifes().size() );
        Assert.assertNotNull( husband.getWifesMap() );
        Assert.assertEquals( 1, husband.getWifesMap().keySet().size() );
        Assert.assertEquals( Introspector.decapitalize( Wife.class.getSimpleName() ), husband.getWifesMap().keySet().iterator().next() );
    }

    @After
    public void after() {
        cxt.destroy();
    }
}
